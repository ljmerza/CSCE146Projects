/*********************************************************************
 * Class implementing a node of a binary tree by storing references
 * to an element, a parent node, and a left and right child.
 *
 * Copyright(C) 2011 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-03-25
**/
public class BTNode<T> implements IBTNode<T>
{
/*********************************************************************
 * Instance Variables
**/
	private BTNode<T> left;
	private BTNode<T> right;
	private BTNode<T> parent;
	private T record;
	
/*********************************************************************
 * Constructor
**/
	public BTNode()
	{
		this.left = null;
		this.right = null;
		this.parent = null;
		this.record = null;
	} // public BTNode()
	
/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to return the height of a node.
 *
 * @return the height.
**/
  public int getHeight()
  {
  	 int height = 0;
  	 BTNode<T> parent = this.getParent();
  	 while( parent != null) 
  	 {
  		 parent = parent.getParent();
  		 ++height;
  	 } // while( parent != null)
  	   
  	 return height;
  } // public int getHeight()

/*********************************************************************
 * Method to get the left child.
 *
 * @return the left child.
**/
  public BTNode<T> getLeft()
  {
  	return this.left;
  } // public BTNode<T> getLeft()

/*********************************************************************
 * Method to set the left.
 *
 * @param v the left node.
**/
  public void setLeft(BTNode<T> newLeft)
  {
  	this.left = newLeft;
  } // public void setLeft(BTNode<T> v)

/*********************************************************************
 * Method to get the parent.
 *
 * @return the parent.
**/
  public BTNode<T> getParent()
  {
  	return this.parent;
  } // public BTNode<T> getParent()

/*********************************************************************
 * Method to set the parent.
 *
 * @param v the parent node.
**/
  public void setParent(BTNode<T> newParent)
  {
  	this.parent = newParent;
  } // public void setParent(BTNode<T> v)

/*********************************************************************
 * Method to return the data payload at this position.
 *
 * @return the data payload.
**/
  public T getRecord()
  {
  	return this.record;
  } // public T getRecord()

/*********************************************************************
 * Method to set the data payload at this position.
 *
 * @param rec the data payload to be set.
**/
  public void setRecord(T rec)
  {
  	this.record = rec;
  } // public void setRecord(T rec)

/*********************************************************************
 * Method to get the right child.
 *
 * @return the right child.
**/
  public BTNode<T> getRight()
  {
  	return this.right;
  } // public BTNode<T> getRight()

/*********************************************************************
 * Method to set the right.
 *
 * @param v the right child to be set.
**/
  public void setRight(BTNode<T> newRight)
  {
  	this.right = newRight;
  } // public void setRight(BTNode<T> v)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to return a boolean as to whether a node has a left child.
 *
 * @return the answer to the question. 
**/
  public boolean hasLeft()
  {
  	return !(this.getLeft()==null);
  } // public boolean hasLeft()

/*********************************************************************
 * Method to return a boolean as to whether a node has a right child.
 *
 * @return the answer to the question. 
**/
  public boolean hasRight()
  {
  	return !(this.getRight()==null);
  } // public boolean hasRight()

/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the <code>toString</code> version of the node's record.
**/
  public String toString()
  {
  	String theString = null;
  	theString = this.record.toString();
  	return theString;
  } // public String toString()

} // public interface IBTNode
