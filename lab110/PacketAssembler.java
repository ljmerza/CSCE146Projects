import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Iterator;
/*********************************************************************
 * Class for building and using HashSet and TreeMap for assembling
 * random input packets into individual messages.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-04-09
**/
public class PacketAssembler implements IPacketAssembler
{
/*********************************************************************
 * Instance variables for the class.
 */
  private final String TAG = "Packet: ";
  private final int MULTIPLIER = 10000;
  private TreeMap<Integer,Integer> countPerMessage;
  private TreeMap<Integer,String> theMessages;
  private HashSet<Integer> theHashSet;
  private Key theKey;
  
  /*********************************************************************
   * Constructor.
  **/
  public PacketAssembler()
  {
	 this.countPerMessage = new TreeMap<Integer,Integer>();
	 this.theMessages = new TreeMap<Integer,String>();
	 this.theHashSet = new HashSet<Integer>();
  } // public PacketAssembler()
  
/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to assemble a message.
 *
 * @param messageId the id number of the message.
 * @return a <code>String</code> of the assembled message.
**/
  private String assembleMessage(int messageId)
  {
	String theString = "";
	
	for(Integer key : this.theMessages.keySet()) 
	{   
		if(getMessageId(key) == messageId)
		{
			theString += this.theMessages.get(key);
			theHashSet.add(key);
		} // if the messageId in the TreeMap is the same as the current messageId
		
	} // Iterate over the keySet the in the TreeMap
	
	Iterator<Integer> itr = theHashSet.iterator();
	while(itr.hasNext())
	{
		this.theMessages.remove(itr.next());
	} // iterate over the HashSet
	  
  	return theString;
  	
  } // private String assembleMessage(int messageId)

/*********************************************************************
 * Method to assemble packets.
 *
 * WE DO NOT BULLETPROOF THE INPUT FOR THIS METHOD.  THIS IS A LAB
 * SO WE MAKE THINGS SIMPLE AND ASSUME THAT WE CAN READ DATA WITHOUT
 * PROBLEMS.
 *
 * @param inFile the file from which to read 
**/
  public void assemblePackets(Scanner inFile)
  {
  	int messageId, packetSequence, packetCount;
    String payload;
    
    while(inFile.hasNext())
    {
    	messageId = inFile.nextInt();
    	packetSequence = inFile.nextInt();
    	packetCount = inFile.nextInt();
    	payload = inFile.nextLine();    	
    	
    	this.storePacket(messageId, packetSequence, packetCount, payload);
    	
    	if(this.incrementCount(messageId, packetCount))
    	{
    		FileUtils.logFile.println(this.assembleMessage(messageId));
    	} // if the count in a message has been incremented
    } // while the input file has a next input
    
  } // public void assemblePackets(Scanner inFile)

/*********************************************************************
 * Method to create a key from a message id and a sequence number.
 *
 * @param messageId the id number of the message.
 * @param packetSequence the sequence number of the packet.
 * @return an <code>int</code> key.
**/
  private int createKey(int messageId, int packetSequence)
  {
  	return this.MULTIPLIER * messageId + packetSequence;
  } // private int createKey(int messageId, int packetSequence)

/*********************************************************************
 * Method to get a message id from a key.
 *
 * @param key the key.
 * @return the message id.
**/
  private int getMessageId(int key)
  {
  	return key / this.MULTIPLIER;
  } // private int getMessageId(int key)

/*********************************************************************
 * Method to get a packet sequence number from a key.
 *
 * @param key the key.
 * @return the packet sequence number.
**/
  private int getPacketSequence(int key)
  {
  	return key % this.MULTIPLIER;
  } // private int getPacketSequence(int key)

/*********************************************************************
 * Method to increment the packet count for a message.
 *
 * @param messageId the id number of the message.
 * @param packetCount the number of packets in the message.
 * @return a <code>boolean</code> saying if all packets have been received.
**/
  private boolean incrementCount(int messageId, int packetCount)
  {
	  
	boolean hasIncremented = false;
	if(this.countPerMessage.containsKey(messageId))
	{
		this.countPerMessage.put(messageId, this.countPerMessage.get(messageId)+1);
	} // if countPerMessage contains key then increment packet count
	else
	{
		this.countPerMessage.put(messageId, 1);
	} // else create new key and start value at one
	
	if(this.countPerMessage.get(messageId) == packetCount)
	{
		hasIncremented = true;
	} // if the message count equals the number of packets in that message
	
	return hasIncremented;
  } // private boolean incrementCount(int messageId, int packetCount)

/*********************************************************************
 * Method to store a packet.
 *
 * @param messageId the id number of the message.
 * @param packetSequence this packet's sequence number;
 * @param packetCount the number of packets in the message.
 * @param packetCount the data payload for the packet.
**/
  public void storePacket(int messageId, int packetSequence,
                          int packetCount, String payload)
  {
  	this.theMessages.put(this.createKey(messageId, packetSequence), payload);
  } // public void storePacket(int messageId, int packetSequence, int packetCount, String payload)

} // public class PacketAssembler
