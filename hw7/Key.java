/*********************************************************************
 * Class for building keys from a packet.  This class will create a 
 * key from the messageId, packetSequence and a multiplier given.
 *
 * @author Leonardo Merza Section 001
 * @version 1.00
**/
public class Key
{
/*********************************************************************
 * Instance variables for the class.
 */
  private int multiplier;
 
/*********************************************************************
 * Constructor.
 **/
  public Key(int newMultiplier)
  {
	 this.multiplier = newMultiplier;
  } // public Key(int newMultiplier)
  
/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/
/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to create a key from a message id and a sequence number.
 *
 * @param messageId the id number of the message.
 * @param packetSequence the sequence number of the packet.
 * @return an <code>int</code> key.
**/
  public int createKey(int messageId, int packetSequence)
  {
  	return this.multiplier * messageId + packetSequence;
  } // private int createKey(int messageId, int packetSequence)

/*********************************************************************
 * Method to get a message id from a key.
 *
 * @param key the key.
 * @return the message id.
**/
  public int getMessageId(int key)
  {
  	return key / this.multiplier;
  } // private int getMessageId(int key)

/*********************************************************************
 * Method to get a packet sequence number from a key.
 *
 * @param key the key.
 * @return the packet sequence number.
**/
  public int getPacketSequence(int key)
  {
  	return key % this.multiplier;
  } // private int getPacketSequence(int key)

} // public class PacketAssembler
