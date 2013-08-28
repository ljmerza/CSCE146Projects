/*********************************************************************
 * Class implementing a node of a binary tree by storing references
 * to an element, a parent node, and a left and right child.
 *
 * Copyright(C) 2011 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell
 * @version 1.00 2011-03-25
**/
public interface IBTNode<T>
{
/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to return the height of a node.
 *
 * @return the height.
**/
  public int getHeight();

/*********************************************************************
 * Method to get the left child.
 *
 * @return the left child.
**/
  public BTNode<T> getLeft();

/*********************************************************************
 * Method to set the left.
 *
 * @param v the left node.
**/
  public void setLeft(BTNode<T> v);

/*********************************************************************
 * Method to get the parent.
 *
 * @return the parent.
**/
  public BTNode<T> getParent();

/*********************************************************************
 * Method to set the parent.
 *
 * @param v the parent node.
**/
  public void setParent(BTNode<T> v);

/*********************************************************************
 * Method to return the data payload at this position.
 *
 * @return the data payload.
**/
  public T getRecord();

/*********************************************************************
 * Method to set the data payload at this position.
 *
 * @param rec the data payload to be set.
**/
  public void setRecord(T rec);

/*********************************************************************
 * Method to get the right child.
 *
 * @return the right child.
**/
  public BTNode<T> getRight();

/*********************************************************************
 * Method to set the right.
 *
 * @param v the right child to be set.
**/
  public void setRight(BTNode<T> v);

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to return a boolean as to whether a node has a left child.
 *
 * @return the answer to the question. 
**/
  public boolean hasLeft();

/*********************************************************************
 * Method to return a boolean as to whether a node has a right child.
 *
 * @return the answer to the question. 
**/
  public boolean hasRight();

/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the <code>toString</code> version of the node's record.
**/
  public String toString();

} // public interface IBTNode
