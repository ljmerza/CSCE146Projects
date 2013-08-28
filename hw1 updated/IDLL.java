/*********************************************************************
 * Interface for the DLL class.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-11
**/
public interface IDLL
{
/*********************************************************************
 * Instance variables for this class.
 * Again we include the variables for guidance purposes.
**/
//  private int size;        /** list size, counting head and tail */
//  private DLLNode head;    /** the head node of the list         */
//  private DLLNode tail;    /** the tail node of the list         */

/*********************************************************************
 * Constructor.
 * I will let you worry about the constructor.
**/

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>head</code>.
 *
 * @return the node that is the value of <code>head</code>.
**/
  public DLLNode getHead();

/*********************************************************************
 * Method to set the <code>head</code>.
 *
 * @param value the value to be used
**/
  public void setHead(DLLNode value);

/*********************************************************************
 * Method to get the <code>size</code>.
 *
 * @return the value of <code>size</code>.
**/
  public int getSize();

/*********************************************************************
 * Method to set the <code>size</code>.
 *
 * @param value the value to be used
**/
  public void setSize(int value);

/*********************************************************************
 * Method to get the <code>tail</code>.
 *
 * @return the node that is the value of <code>tail</code>.
**/
  public DLLNode getTail();

/*********************************************************************
 * Method to set the <code>tail</code>.
 *
 * @param value the value to be used
**/
  public void setTail(DLLNode value);

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a node.
 * By default this adds the node at the head.
 * We deliverately fail to bulletproof w.r.t. the return value.
 *
 * @param dllData the <code>Record</code> data item to add.
**/
  public boolean add(Record dllData);

/*********************************************************************
 * Method to find if a list has a given data item. 
 *
 * @param dllData the <code>Record</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(Record dllData);

/*********************************************************************
 * Method to remove a node with a given record as data. 
 *
 * @param dllData the <code>Record</code> to match against. 
 *
 * @return the <code>boolean</code> as to whether the record was
 *         found and removed or not.
**/
  public boolean remove(Record dllData);

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head and
 * tail nodes.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString();

} // public class DLL implements IDLL
