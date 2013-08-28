/*********************************************************************
 * Class to handle a node for a doubly-linked list.
 * This code implements a standard node in a doubly-linked list.
 * Instance variables are
 *   <code>next</code>,
 *   <code>prev</code>,
 *   <code>nodeData</code>,
 * and all but the last are standard and no methods exist here
 * except the accessors and mutators for the instance variables and
 * the standard <code>toString</code> that returns a formatted
 * version of the data payload.
 *
 * Note that this hard-codes the data payload as an item of
 * <code>Record</code> type, and this ought to be reworked to use
 * generics.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-11
**/

public class DLLNode implements IDLLNode
{
//  private static final String classLabel = "DLLNode: ";
  private DLLNode next;
  private DLLNode prev;
  private Record nodeData;

/*********************************************************************
 * Constructor for a node with totally dummy data;.
**/
  public DLLNode()
  {
    super();
    this.setNext(null);
    this.setPrev(null);
    this.setNodeData(null);
  } // public DLLNode()

/*********************************************************************
 * Constructor for a dummy node with nulls.
**/
  public DLLNode(Record data)
  {
    super();
    this.setNext(null);
    this.setPrev(null);
    this.setNodeData(data);
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
  } // public Record getNodeData()

/*********************************************************************
 * Method to set the <code>nodeData</code>.
 *
 * @param newData the new value for the <code>nodeData</code>.
**/
  public void setNodeData(Record newData)
  {
    this.nodeData = newData;
  } // public void setNodeNext(Record newData)

/*********************************************************************
 * Method to get the <code>next</code> node.
 *
 * @return the next <code>DLLNode</code>.
**/
  public DLLNode getNext()
  {
    return this.next;
  } // public DLLNode getNext()

/*********************************************************************
 * Method to set the <code>next</code> node.
 *
 * @param newNext the new value for the next <code>DLLNode</code>.
**/
  public void setNext(DLLNode newNext)
  {
    this.next = newNext;
  } // public void setNext(DLLNode newNext)

/*********************************************************************
 * Method to get the <code>previous<code> node.
 *
 * @return the previous <code>DLLNode</code>.
**/
  public DLLNode getPrev()
  {
    return this.prev;
  } // public DLLNode getPrev()

/*********************************************************************
 * Method to set the <code>previous<code> node.
 *
 * @param newNext the new value for the previous <code>DLLNode</code>.
**/
  public void setPrev(DLLNode newPrev)
  {
    this.prev = newPrev;
  } // public void setPrev(DLLNode newPrev)

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
    String s = "";

    if(null == this.nodeData)
    {
      s = "Dummy Node";
    }
    else
    {
      s = this.nodeData.toString();
    }

    return s;
  } // public String toString()

} // public class DLLNode implements IDLLNode
