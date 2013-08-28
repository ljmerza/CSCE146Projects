import java.util.Scanner;
import java.util.TreeMap;
import java.util.InputMismatchException;
/*********************************************************************
 * Class for building and using TreeMap for assembling
 * random input packets into individual messages.
 *
 * @author Leonardo Merza Section 001
 * @version 1.00
**/
public class PacketAssembler
{
/*********************************************************************
 * Instance variables for the class.
 */
  private final String TAG = "PacketAssembler: ";
  //private final int MULTIPLIER = 10000;
  
  private TreeMap<Integer, TreeMap<Integer,String>> theTreeMaps; // messageId, theMessages
  private TreeMap<Integer,Integer> countPerMessage; // messageId, count so far
  private TreeMap<Integer,String> theMessages; // packetSequence, String data
  
  /*********************************************************************
   * Constructor.
  **/
  public PacketAssembler()
  {
  	this.theTreeMaps = new TreeMap<Integer, TreeMap<Integer,String>>();
  	this.countPerMessage = new TreeMap<Integer,Integer>();
  } // public PacketAssembler()
  
/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to assemble packets. Will read a file and verify if the packet
 * is a complete packet.  If it is then this method will store the packet
 * in a TreeMap and then check to see if the complete message has been 
 * received.  If the complete message has been received, then this method
 * will assemble the message.  If a packet is not complete then it will
 * discard the packet.
 *
 * @param inFile the file from which to read 
**/
  public void assemblePackets(Scanner inFile)
  {
  	boolean isNotCompletePacket;
  	int messageId = 0, packetSequence = 0, packetCount = 0;
  	String payload = "";
      
    while( inFile.hasNext() )
    {
    	isNotCompletePacket = false;
    	
    	try
    	{
      	messageId = inFile.nextInt();
      	packetSequence = inFile.nextInt();
      	packetCount = inFile.nextInt();
    	} // try to get three integers from Scanner file
    	catch(InputMismatchException e)
    	{
    		inFile.nextLine();
    		isNotCompletePacket = true;
    	} // if three integers are not present then discard packet

    	if( !(isNotCompletePacket) )
    	{
    		payload = inFile.nextLine();
    		this.storePacket(messageId, packetSequence, packetCount, payload);	
        
        if( this.checkForCompleteMessage(messageId, packetCount) )
        {
        	FileUtils.logFile.println(this.TAG + this.assembleMessage(messageId));
        } // if the entire message has been received then assemble message and print to log
    	} // if the packet is a complete packet then store and check for complete message
      
    } // while the input file has a next input
      
  } // public void assemblePackets(Scanner inFile)

/*********************************************************************
 * Method to store a packet. This will see if the TreeMap already 
 * contains the messaageId and if it does then it will check to 
 * see if the packet is already there and if it is it will be 
 * replaced by the new packet.  If the packet doesn't exist then
 * this method will add the new packet and increment the packet count
 * of the message.  If the message is not in the TreeMap then it will
 * simply create a new TreeMap to store the new messageIs and start
 * the new count at one.
 *
 * @param messageId the id number of the message.
 * 
 * @param packetSequence this packet's sequence number.
 * 
 * @param packetCount the number of packets in the message.
 * 
 * @param payload the data pay load for the packet.
**/
  public void storePacket(int messageId, int packetSequence, int packetCount, String payload)
	{
	
    if( this.theTreeMaps.containsKey(messageId) )
    {
    	if( !(this.theTreeMaps.get(messageId).containsKey(packetSequence)) )
    	{
    		this.countPerMessage.put(messageId, this.countPerMessage.get(messageId)+1);
    	} // if the packet does not exist in the message TreeMap then add one to the counter
    } // if the TreeMap already contains the messageId
    else
    {
    	this.theTreeMaps.put(messageId, (this.theMessages = new TreeMap<Integer,String>()));
    	this.countPerMessage.put(messageId, 1);
    } // if the messageId is new to the TreeMap then make new TreeMap and start message counter at one
    
    this.theTreeMaps.get(messageId).put(packetSequence, payload);
  	
  } // public void storePacket(int messageId, int packetSequence, int packetCount, String payload)

/*********************************************************************
 * Method to assemble a message.
 *
 * @param messageId the id number of the message.
**/
  private String assembleMessage(int messageId)
  {
  	String theString = "";
  	
  	for( Integer key : this.theTreeMaps.get(messageId).keySet() ) 
  	{   
  		theString += this.theTreeMaps.get(messageId).get(key);
  	} // if the messageId in the TreeMap is the same as the current messageId
  	
  	this.theTreeMaps.remove(messageId);
  	
  	return theString;
  } // private String assembleMessage(int messageId)

/*********************************************************************
 * Method to check if a message has been completely received.
 *
 * @param messageId the id number of the message.
 * 
 * @param the boolean value of if the message has been 
 * completely received.
**/
  private boolean checkForCompleteMessage(int messageId, int packetCount)
  {
  	boolean isCompleteMessage;
  	isCompleteMessage = false;
  	
  	if( packetCount == this.countPerMessage.get(messageId) )
  	{
  		isCompleteMessage = true;
  	} // if the packetCount is equal to the number of packets received for a message
  	
  	return isCompleteMessage;
  } // private boolean checkForCompleteMessage(int messageId, int packetCount)

} // public class PacketAssembler   