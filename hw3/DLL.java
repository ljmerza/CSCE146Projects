/*********************************************************************
 * Doubly linked list class that implements a head and tail node
 * and sets the size of the DLL. Contains accessor and mutator methods for 
 * DLL head and tail as well as the integer size for the size of the DLL.
 * General methods add new new node, remove an old node, and a contains method
 * inputs a record to see if the searched DLL contains that record. Also included
 * are an unlink method to unlink nodes and a toString for converting record 
 * objects to a string.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-11
**/

public class DLL<T extends Comparable<T>> implements IDLL<T>
{
/*********************************************************************
 * Instance variables for this class.
**/

  private int size;        /** list size, counting head and tail */
  private DLLNode<T> head;    /** the head node of the list         */
  private DLLNode<T> tail;    /** the tail node of the list         */

/*********************************************************************
 * Constructor.
**/
  public DLL()
  {
    this.setHead(new DLLNode<T>());
    this.setTail(new DLLNode<T>());
    head.setNext(this.tail);
    tail.setPrev(this.head);
    this.setSize(2);
  } // public DLL()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>head</code>.
 *
 * @return the node that is the value of <code>head</code>.
**/
  public DLLNode<T> getHead()
  {
    return this.head;
  } // public DLLNode getHead()

/*********************************************************************
 * Method to set the <code>head</code>.
 *
 * @param value the value to be used
**/
  public void setHead(DLLNode<T> value)
  {
    this.head = value;
  } // private void setHead(DLLNode value)

/*********************************************************************
 * Method to get the <code>size</code>.
 *
 * @return the value of <code>size</code>.
**/
  public int getSize()
  {
    return this.size;
  } // public int getSize()

/*********************************************************************
 * Method to decrement the <code>size</code>.
**/
  private void decSize()
  {
    this.setSize(this.size - 1);
  } // private void decSize()

/*********************************************************************
 * Method to increment the <code>size</code>..
**/
  private void incSize()
  {
    this.setSize(this.size + 1);
  } // private void incSize()

/*********************************************************************
 * Method to set the <code>size</code>.
 *
 * @param value the value to be used
**/
  public void setSize(int value)
  {
    this.size = value;
  } // public void setSize(int value)

/*********************************************************************
 * Method to get the <code>tail</code>.
 *
 * @return the node that is the value of <code>tail</code>.
**/
  public DLLNode<T> getTail()
  {
    return this.tail;
  } // public DLLNode getTail()

/*********************************************************************
 * Method to set the <code>tail</code>.
 *
 * @param value the value to be used
**/
  public void setTail(DLLNode<T> value)
  {
    this.tail = value;
  } // private void setTail(DLLNode value)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a node by using the sortAdd method to add a node
 * alphabetically based on the candidate name.
 *
 * @param record the <code>Record</code> data item to add.
**/
  public boolean add(T dllData)
  {
    this.addAtHead(dllData);
    return true;
  } // public boolean add(T dllData)

/*********************************************************************
 * Method to add a node at the head.
 *
 * @param dllData the <code>T</code> data item to add.
 * @return a <code>boolean</code> that says the add went ok
**/
  public boolean addAtHead(T dllData)
  {
    DLLNode<T> newNode = null;
    newNode = new DLLNode<T>();
    newNode.setNodeData(dllData);
    this.linkAfter(this.getHead(), newNode);
    return true;
  } // private void addAtHead(T dllData)

/*********************************************************************
 * Method to find if a list has a given data item. 
 *
 * @param dllData the <code>Record</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(T dllData)
  {
    boolean returnValue = false;
    DLLNode<T> foundNode = null;
    foundNode = this.containsNode(dllData);
    if(null != foundNode)
    {
      returnValue = true;
    }
    return returnValue;
  } // public boolean contains(T dllData)

/*********************************************************************
 * Method to return the node with a given data item in it, else null.
 * This method eliminates duplicate code in <code>contains</code>
 * and <code>remove</code>. 
 *
 * @param dllData the <code>Record</code> to match against. 
 *
 * @return the <code>DLLNode</code> answer, else null.
**/
  private DLLNode<T> containsNode(T dllData)
  {
    DLLNode<T> returnValue = null;
    DLLNode<T> currentNode = null;

    currentNode = this.getHead();
    currentNode = currentNode.getNext();
    while(currentNode != this.getTail())
    {
      if(0 == currentNode.getNodeData().compareTo(dllData))
      {
        returnValue = currentNode;
        break; // we violate the style rule
      }
      currentNode = currentNode.getNext();
    }

    return returnValue;
  } // private DLLNode containsNode(T dllData)

/*********************************************************************
 * Method to remove a node with a given record as data. 
 *
 * @param dllData the <code>Record</code> to match against. 
 *
 * @return the <code>boolean</code> as to whether the record was
 *         found and removed or not.
**/
  public boolean remove(T dllData)
  {
    boolean returnValue = false;
    DLLNode<T> foundNode = null;
    foundNode = this.containsNode(dllData);
    if(null != foundNode)
    {
      this.unlink(foundNode);
      returnValue = true;
    }
    return returnValue;
  } // public boolean remove(T dllData)
    
/*********************************************************************
 * Method to link a node after a given node. 
 *
 * @param baseNode the <code>DLLNode</code> to be linked after. 
 * @param newNode the <code>DLLNode</code> to be linked in. 
**/
  private void linkAfter(DLLNode<T> baseNode, DLLNode<T> newNode)
  {
    newNode.setNext(baseNode.getNext());
    newNode.setPrev(baseNode);

    baseNode.getNext().setPrev(newNode);
    baseNode.setNext(newNode);

    this.incSize();
  } // private void linkAfter(DLLNode baseNode, DLLNode newNode)

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head and
 * tail nodes.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
    String string = "";
    DLLNode<T> node;

    node = this.head;
    while(node != this.getTail())
    {
      node = node.getNext();
      string += node.toString();
    } // while loop
    
    return string;
  } // public String toString()

/*********************************************************************
 * Method to unlink a node.
 *
 * @param node the <code>DLLNode</code> to unlink.
**/
  private void unlink (DLLNode<T> node)
  {
    node.getNext().setPrev(node.getPrev());
    node.getPrev().setNext(node.getNext());

    node.setNext(null);
    node.setPrev(null);

    this.decSize();
  } // private void unlink(DLLNode node)
  
} // public class DLL implements IDLL