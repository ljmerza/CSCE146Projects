/*********************************************************************
 * DLLNode class that creates DLLNodes with next and previous links to
 * other nodes in the DLL. Accessor and mutator methods for the next and
 * previous DLLNode objects as well as for a record object. A toString is
 * provided to change a DLLNode into a string.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza
 * @version 1.00 2011-01-22
**/

public class DLLNode implements IDLLNode
{
/*********************************************************************
 * Instance variables for this class.
**/
	private DLLNode next;
	private DLLNode prev;
	private Record nodeData;

/*********************************************************************
 * Constructor.
**/
	public DLLNode()
	{
		// next = new DLLNode<record>();
		// prev = new DLLNode<record>();
		nodeData = new Record();
	} // public DLLNode()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>nodeData</code>.
 *
 * @return the <code>nodeData</code>.
**/
  public Record getNodeData()
  {
		return this.nodeData;
	} // getNodeData method

/*********************************************************************
 * Method to set the <code>nodeData</code>.
 *
 * @param newData the new value for the <code>nodeData</code>.
**/
  public void setNodeData(Record newData)
  {
		this.nodeData = newData;
	} // setNodeData method

/*********************************************************************
 * Method to get the <code>next</code> node.
 *
 * @return the next <code>DLLNode</code>.
**/
  public DLLNode getNext()
  {
		return this.next;
	} // getNext method

/*********************************************************************
 * Method to set the <code>next</code> node.
 *
 * @param newNext the new value for the next <code>DLLNode</code>.
**/
  public void setNext(DLLNode newNext)
  {
		this.next = newNext;
	} // setNext method

/*********************************************************************
 * Method to get the <code>previous<code> node.
 *
 * @return the previous <code>DLLNode</code>.
**/
  public DLLNode getPrev()
  {
		return this.prev;
	} // getPrev method

/*********************************************************************
 * Method to set the <code>previous<code> node.
 *
 * @param newPrev the new value for the previous <code>DLLNode</code>.
**/
  public void setPrev(DLLNode newPrev)
  {
		this.prev = newPrev;
	} // setPrev method

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to return a <code>toString</code> of the node data.
 *
 * @return the <code>String</code> value for the node's data.
**/
  public String toString()
  {
		String theString;
		theString = nodeData.toString();
		return theString;
	} // toString method

} // public class DLLNode
