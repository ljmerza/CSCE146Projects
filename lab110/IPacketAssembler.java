import java.util.Scanner;
/*********************************************************************
 * Class for building and using HashSet and TreeMap for assembling
 * random input packets into individual messages.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-04-09
**/
public interface IPacketAssembler
{
/*********************************************************************
 * Instance variables for the class.
  private final String TAG = "Packet: ";
  private final int MULTIPLIER = 10000;
  private TreeMap<Integer,Integer> countPerMessage;
  private TreeMap<Integer,String> theMessages;
**/

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
//  private String assembleMessage(int messageId);

/*********************************************************************
 * Method to assemble packets.
 *
 * WE DO NOT BULLETPROOF THE INPUT FOR THIS METHOD.  THIS IS A LAB
 * SO WE MAKE THINGS SIMPLE AND ASSUME THAT WE CAN READ DATA WITHOUT
 * PROBLEMS.
 *
 * @param inFile the file from which to read 
**/
  public void assemblePackets(Scanner inFile);

/*********************************************************************
 * Method to create a key from a message id and a sequence number.
 *
 * @param messageId the id number of the message.
 * @param packetSequence the sequence number of the packet.
 * @return an <code>int</code> key.
**/
//  private int createKey(int messageId, int packetSequence);

/*********************************************************************
 * Method to get a message id from a key.
 *
 * @param key the key.
 * @return the message id.
**/
//  private int getMessageId(int key);

/*********************************************************************
 * Method to get a packet sequence number from a key.
 *
 * @param key the key.
 * @return the packet sequence number.
**/
//  private int getPacketSequence(int key);

/*********************************************************************
 * Method to increment the packet count for a message.
 *
 * @param messageId the id number of the message.
 * @param packetCount the number of packets in the message.
 * @return a <code>boolean</code> saying if all packets have been received.
**/
//  private boolean incrementCount(int messageId, int packetCount);

/*********************************************************************
 * Method to store a packet.
 *
 * @param messageId the id number of the message.
 * @param packetSequence this packet's sequence number;
 * @param packetCount the number of packets in the message.
 * @param packetCount the data payload for the packet.
**/
  public void storePacket(int messageId, int packetSequence,
                          int packetCount, String payload);

} // public interface IPacketAssembler
