/*********************************************************************
 * DLLNode class that creates DLLNodes with next and previous links to
 * other nodes in the DLL. Accessor and mutator methods for the next and
 * previous DLLNode objects as well as for a record object. A toString is
 * provided to change a DLLNode into a string.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-11
**/

public class DLLNode<T> implements IDLLNode<T>
{
/*********************************************************************
 * Usual comments about instance variables.
**/
	private DLLNode<T> next;
	private DLLNode<T> prev;
	private T nodeData;

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>nodeData</code>.
 *
 * @return the <code>nodeData</code>.
**/
  public T getNodeData()
  {
		return this.nodeData;
	} // getNodeData method

/*********************************************************************
 * Method to set the <code>nodeData</code>.
 *
 * @param newData the new value for the <code>nodeData</code>.
**/
  public void setNodeData(T newData)
  {
		this.nodeData = newData;
	} // setNodeData method

/*********************************************************************
 * Method to get the <code>next</code> node.
 *
 * @return the next <code>DLLNode</code>.
**/
  public DLLNode<T> getNext()
  {
		return this.next;
	} // getNext method

/*********************************************************************
 * Method to set the <code>next</code> node.
 *
 * @param newNext the new value for the next <code>DLLNode</code>.
**/
  public void setNext(DLLNode<T> newNext)
  {
		this.next = newNext;
	} // setNext method

/*********************************************************************
 * Method to get the <code>previous<code> node.
 *
 * @return the previous <code>DLLNode</code>.
**/
  public DLLNode<T> getPrev()
  {
		return this.prev;
	} // getPrev method

/*********************************************************************
 * Method to set the <code>previous<code> node.
 *
 * @param newNext the new value for the previous <code>DLLNode</code>.
**/
  public void setPrev(DLLNode<T> newPrev)
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
  	String theString = "";

    if(null == this.nodeData)
    {
    	theString = "Dummy Node";
    } // if statement
    else
    {
    	theString = this.nodeData.toString();
    } // else statement

    return theString;
	} // toString method
  
} // public interface IDLLNode<T>
