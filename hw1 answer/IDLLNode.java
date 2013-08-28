/*********************************************************************
 * Interface for the DLLNode class.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-11
**/

public interface IDLLNode
{
/*********************************************************************
 * Usual comments about instance variables.
**/
//  private DLLNode<Record> next;
//  private DLLNode<Record> prev;
//  private Record nodeData;

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>nodeData</code>.
 *
 * @return the <code>nodeData</code>.
**/
  public Record getNodeData();

/*********************************************************************
 * Method to set the <code>nodeData</code>.
 *
 * @param newData the new value for the <code>nodeData</code>.
**/
  public void setNodeData(Record newData);

/*********************************************************************
 * Method to get the <code>next</code> node.
 *
 * @return the next <code>DLLNode</code>.
**/
  public DLLNode getNext();

/*********************************************************************
 * Method to set the <code>next</code> node.
 *
 * @param newNext the new value for the next <code>DLLNode</code>.
**/
  public void setNext(DLLNode newNext);

/*********************************************************************
 * Method to get the <code>previous<code> node.
 *
 * @return the previous <code>DLLNode</code>.
**/
  public DLLNode getPrev();

/*********************************************************************
 * Method to set the <code>previous<code> node.
 *
 * @param newNext the new value for the previous <code>DLLNode</code>.
**/
  public void setPrev(DLLNode newPrev);

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to return a <code>toString</code> of the node data.
 *
 * @return the <code>String</code> value for the node's data. 
**/
  public String toString();

} // public interface IDLLNode<T>
