/*********************************************************************
 * Doubly linked list class that implements a head and tail node
 * and sets the size of the DLL. Contains accessor and mutator methods for 
 * DLL head and tail as well as the integer size for the size of the DLL.
 * General methods add new new node, remove an old node, and a contans method
 * inputs a record to see if the searched DLL contains that record. Also included
 * are an unlink method to unlink nodes and a toString for converting record 
 * objects to a string.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza
 * @version 1.00 2011-01-22
**/

public class DLL implements IDLL
{
/*********************************************************************
 * Instance variables for this class.
**/
	private final int initialNodeSize = 2;

	private int size;        /** list size, counting head and tail */
	private DLLNode head;    /** the head node of the list         */
	private DLLNode tail;    /** the tail node of the list         */

/*********************************************************************
 * Constructor. Creates a new instance of head and tail DLLNodes
 * as well as sets the head and tail to link to each other. Sets
 * size of DLL to 2.
**/
	public DLL()
	{
		head = new DLLNode();
		tail = new DLLNode();
		head.setNext(tail);
		tail.setPrev(head);
		this.setSize(this.initialNodeSize);
	} // public DLL()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>head</code> of a DLL.
 *
 * @return the node that is the value of <code>head</code>.
**/
  public DLLNode getHead()
  {
		return this.head;
	} // getHead method

/*********************************************************************
 * Method to set the <code>head</code> of a DLL.
 *
 * @param value the value to be used in the head node.
**/
  public void setHead(DLLNode value)
  {
		this.head = value;
	} // setHead method

/*********************************************************************
 * Method to get the <code>size</code> of the DLL.
 *
 * @return the value of <code>size</code> of the DLL.
**/
  public int getSize()
  {
		return this.size;
	} // getSize method

/*********************************************************************
 * Method to set the <code>size</code> of the DLL.
 *
 * @param value the value to be used for setting the size
 * of the DLL.
**/
  public void setSize(int value)
  {
		this.size = value;
	} // setSize method

/*********************************************************************
 * Method to get the <code>tail</code> node of the DLL.
 *
 * @return the node that is the value of <code>tail</code>.
**/
  public DLLNode getTail()
  {
		return this.tail;
	} // getTail method

/*********************************************************************
 * Method to set the <code>tail</code> node of the DLL.
 *
 * @param value the value to be used in setting the <code>tail</code> 
 * of the DLL.
**/
  public void setTail(DLLNode value)
  {
		this.tail = value;
	} // setTail method

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a node to the current DLL. By default this adds the
 * node before the tail node.
 * 
 * @param dllData the <code>Record</code> data item to add to
 * the new node.
**/
  public boolean add(Record dllData)
  {
		boolean isAdded = false;
		DLLNode newNode = null;
		newNode = new DLLNode();
		newNode.setNodeData(dllData);

		newNode.setNext(tail);
		newNode.setPrev(tail.getPrev());
		tail.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		size++;
		
		isAdded = true;
		return isAdded;
	} // add method

/*********************************************************************
 * Method to add a node to the current DLL. By default this adds the 
 * node at the head.
 *
 * @param dllData the <code>Record</code> data item to add to
 * the new node.
**/
  public void addAtHead(Record dllData)
  {
		DLLNode newNode = null;
		newNode = new DLLNode();
		newNode.setNodeData(dllData);

		newNode.setPrev(head);
		newNode.setNext(head.getNext());
		head.getNext().setPrev(newNode);
		head.setNext(newNode);
		size++;

	} // addAtHead method

/*********************************************************************
 * Method to find if a list has a given data item.
 *
 * @param dllData the <code>Record</code> to match against.
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(Record dllData)
  {
	  	int currentNodeNumber = 2;
		boolean hasContained = false;
		DLLNode current = head.getNext();
		

		while ( (currentNodeNumber < this.getSize()) )
				{
					if( dllData.equals(current.getNodeData()) )
					{
						hasContained = true;
						break;
					} // if statement
					else
					{
						current = current.getNext();
						currentNodeNumber++;			
					} // else statement
		} // while loop
		
		return hasContained;
	} // contains method

/*********************************************************************
 * Method to remove a node with a given record as data.
 *
 * @param dllData the <code>Record</code> to match against.
 *
 * @return the <code>boolean</code> as to whether the record was
 *         found and removed or not.
**/
  public boolean remove(Record dllData)
  {
		boolean isRemoved= false;
		DLLNode current = head.getNext();
		int currentNodeNumber = 2;		

		while ( (currentNodeNumber < this.getSize()) )
				{
					if( dllData.equals(current.getNodeData()) )
					{
						this.unlink(current);
						isRemoved = true;
						break;
					} // if statement
					else
					{
						current = current.getNext();
						currentNodeNumber++;			
					} // else statement
		} // while loop
		
		return isRemoved;
	} // remove method

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head and
 * tail nodes.
 *
 * @return the <code>toString</code> representation of the entire DLL.
**/
  public String toString(Record record)
  {
		String theString;
		theString = record.toString();
		return theString;
	} // toString method

/*********************************************************************
 * Method to <code>unlink</code> nodes from a DLL.
 *
 * @param node the DLLnode object that will be unlinked
**/
  private void unlink(DLLNode node)
  {
	  	if((node.getNext() == null) && (node.getPrev() == null))
	  	{
	  		throw new InvalidNodeException("next or previous value is a null");
	  	} // if statement
	  	
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		node.setPrev(null);
		node.setNext(null);
		size--;
	} // unlink method

} // public class DLL implements IDLL
