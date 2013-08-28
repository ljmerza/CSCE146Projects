/*********************************************************************
 * Class for a doubly linked list.
 *
 * This class differs from earlier DLL code in that we have added
 * a method to insert an entry based on the <code>compareTo</code>
 * of the data.
 *
 * It should also be noted that the mutator methods probably
 * ought to be private and not public, but I can't force 
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
h* @version 1.00 2011-02-10
**/
public class DLL<T extends Comparable<T>> implements IDLL<T>
{
/*********************************************************************
 * Instance variables for this class.
**/
//  private static final String classLabel = "DLL: ";

  private int size;        /** list size, counting head and tail */
  private DLLNode<T> head; /** the head node of the list         */
  private DLLNode<T> tail; /** the tail node of the list         */

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
  } // public DLLNode<T> getHead()

/*********************************************************************
 * Method to set the <code>head</code>.
 *
 * @param value the value to be used
**/
  private void setHead(DLLNode<T> value)
  {
    this.head = value;
  } // private void setHead(DLLNode<T> value)

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
 * We include this as a mutator because it will be used as if a
 * 'set' operation.
**/
  private void decSize()
  {
    this.setSize(this.size - 1);
  } // private void decSize()

/*********************************************************************
 * Method to increment the <code>size</code>.
 * We include this as a mutator because it will be used as if a
 * <code>set</code> operation.
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
  private void setSize(int value)
  {
    this.size = value;
  } // private void setSize(int value)

/*********************************************************************
 * Method to get the <code>tail</code>.
 *
 * @return the node that is the value of <code>tail</code>.
**/
  public DLLNode<T> getTail()
  {
    return this.tail;
  } // public DLLNode<T> getTail()

/*********************************************************************
 * Method to set the <code>tail</code>.
 *
 * @param value the value to be used
**/
  private void setTail(DLLNode<T> value)
  {
    this.tail = value;
  } // private void setTail(DLLNode<T> value)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a node.
 * By default this adds the node at the head.
 * We deliverately fail to bulletproof w.r.t. the return value.
 *
 * @param dllData the <code>T</code> data item to add.
**/
  public boolean add(T dllData)
  {
    this.addAtHead(dllData);
    return true;
  } // public boolean add(T dllData)

/*********************************************************************
 * Method to add a node at the head of a linked list. 
 *
 * @param newNode the <code>DLLNode</code> node to add. 
**/
  private void addAtHead(T dllData)
  {
    DLLNode<T> newNode = null;
    newNode = new DLLNode<T>();
    newNode.setNodeData(dllData);
    this.linkAfter(this.getHead(), newNode);
  } // private void addAtHead(T dllData)

/*********************************************************************
 * Method to find if a list has a given data item. 
 *
 * @param dllData the <code>T</code> to match against. 
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
 * @param dllData the <code>T</code> to match against. 
 *
 * @return the <code>DLLNode</code> answer, else null.
**/
  public DLLNode<T> containsNode(T dllData)
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
  } // public DLLNode<T> containsNode(T dllData)

/*********************************************************************
 * Method to insert a node in a proper sorting location.
 *
 * The method starts from the tail and pulls forward. We could
 * equally well have started from the head and pushed forward,
 * but we happened to have a <code>linkAfter</code> method already
 * written that can be used with simpler code.
 *
 * @param dllData the <code>T</code> to match against. 
**/
  public void insert(T dllData)
  {

    DLLNode<T> baseNode = new DLLNode<T>();
    DLLNode<T> newNode = new DLLNode<T>(dllData);
    baseNode = this.getTail().getPrev();


// Walk forward until we either hit the dummy head whose data
// is null, or an entry with "smaller" data than the data to
// be inserted.
    while((baseNode.getNodeData() != null) &&
          (newNode.getNodeData().compareTo(baseNode.getNodeData()) < 0))
    {
//      FileUtils.logFile.printf("DLLA: %s%n",
//                                newNode.getNodeData().toString());
//      FileUtils.logFile.flush();
//      FileUtils.logFile.printf("DLLB: %s%n",
//                                baseNode.getNodeData().toString());
//      FileUtils.logFile.flush();
      baseNode = baseNode.getPrev();
    }
    this.linkAfter(baseNode, newNode);

  } // public void insert(T dllData)

/*********************************************************************
 * Method to remove a node with a given record as data. 
 *
 * @param dllData the <code>T</code> to match against. 
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
 * Method to remove a node at a given subscript.
 *
 * @param sub the subscript of the node to remove. 
 *
 * @return the subscript of the node removed,
 *         or else a negative number.
**/
  private int remove(int which)
  {
    int returnValue = -1;
    DLLNode<T> currentNode = null;

    if(which <= 0) // must include 0 as dummy head node
    {
//      FileUtils.logFile.printf("%s cannot remove negative sub %d%n",
//                   classLabel, which);
    }
    else if(which >= this.getSize()-1) // must include size-1 as dummy tail node
    {
//      FileUtils.logFile.printf("%s cannot remove too-large sub %d%n",
//                   classLabel, which);
    }
    else
    {
//      FileUtils.logFile.printf("%s remove sub %d%n",
//                   classLabel, which);
      currentNode = this.getHead().getNext(); // start at first real node
      for(int i = 1; i < which; ++i)
      {
        currentNode = currentNode.getNext();
      }
      this.unlink(currentNode);
      returnValue = which;
    }

    return returnValue;
  } // private int remove(int which)

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
  } // private void linkAfter(DLLNode<T> baseNode, DLLNode<T> newNode)

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head and
 * tail nodes.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
    int sequence;
    String s = "";
    DLLNode<T> node;

    s += String.format("There are %d entries%n", 
                       this.getSize());
    s += String.format("going forward%n");

// note that we include the head and then also the tail
    sequence = 0;
    node = this.head;
    s += String.format("%3d: %s%n", sequence, node.toString());
    while(node != tail)
    {
      node = node.getNext();
      ++sequence;
      s += String.format("%3d: %s%n", sequence, node.toString());
    }

/*
    s += "\n";
    s += String.format("going backward%n");
    sequence = 0;
    node = this.tail;
    s += String.format("%3d: %s%n", sequence, node.toString());
    while(node != head)
    {
      node = node.getPrev();
      ++sequence;
      s += String.format("%3d: %s%n", sequence, node.toString());
    }
*/

    return s;
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
  } // private void unlink(DLLNode<T> node)

} // public class DLL<T extends Comparable<T>> implements IDLL
