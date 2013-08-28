/*********************************************************************
 * Interface for the DLL class.
 *
 * The private mutator methods have been listed here to make sure
 * they are included in the "must have" list, but the Java
 * <code>interface</code> doesn't permit <code>private</code>
 * things to be included.  So they have been included as text but
 * commented out.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-11
**/
public interface IDLL<T extends Comparable<T>>
{
/*********************************************************************
 * Instance variables for this class.
 * Again we include the variables for guidance purposes.
**/
//  private int size;        /** list size, counting head and tail */
//  private DLLNode<T> head; /** the head node of the list         */
//  private DLLNode<T> tail; /** the tail node of the list         */

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
  public DLLNode<T> getHead();

/*********************************************************************
 * Method to set the <code>head</code>.
 *
 * @param value the value to be used
  private void setHead(DLLNode<T> value);
**/

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
  private void setSize(int value);
**/

/*********************************************************************
 * Method to get the <code>tail</code>.
 *
 * @return the node that is the value of <code>tail</code>.
**/
  public DLLNode<T> getTail();

/*********************************************************************
 * Method to set the <code>tail</code>.
 *
 * @param value the value to be used
  private void setTail(DLLNode<T> value);
**/

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
  public boolean add(T dllData);

/*********************************************************************
 * Method to find if a list has a given data item. 
 *
 * @param dllData the <code>T</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(T dllData);

/*********************************************************************
 * Method to remove a node with a given record as data. 
 *
 * @param dllData the <code>T</code> to match against. 
 *
 * @return the <code>boolean</code> as to whether the record was
 *         found and removed or not.
**/
  public boolean remove(T dllData);

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head and
 * tail nodes.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString();

} // public class DLL<T extends Comparable<T>> implements IDLL
