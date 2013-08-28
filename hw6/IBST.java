/*********************************************************************
 * Interface for a binary search tree.
 *
 * Copyright(C) 2011 Duncan A. Buell. All rights reserved.
 *
 * @author Duncan Buell
 * @version 1.00 2011-03-25
**/
public interface IBST<T extends Comparable<T>>
{

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to return the average height of the tree.
 *
 * @return the average height of the tree.
**/
  public double getAverageHeight();

/*********************************************************************
 * Method to return the <code>maxHeight</code> of the tree.
 *
 * @return the <code>maxHeight</code> of the tree.
**/
  public int getMaxHeight();

/*********************************************************************
 * Method to return the <code>nodeCount</code> of the tree.
 *
 * @return the <code>nodeCount</code> (number of elements) in the tree.
**/
  public int getNodeCount();

/*********************************************************************
 * Method to return the root of the tree.
 *
 * @return the root node.
**/
  public BTNode<T> getRoot();

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to test to see if a particular data payload is in the tree. 
 *
 * @return the answer to the question.
**/
  public boolean contains(T testRecord);

/*********************************************************************
 * Method to insert a node.
 *
 * @param rec the node to be inserted.
 * @return the node inserted.
**/
  public BTNode<T> insert(T rec);

/*********************************************************************
 * Method to return a boolean as to whether the tree is empty.
 *
 * @return the answer to the question.
**/
  public boolean isEmpty();

/*********************************************************************
 * Method to convert the tree to a <code>String</code> in inorder.
 *
 * @param v the root node from which to traverse the tree.
 * @return the inorder <code>String</code> version of the tree.
**/
  public String toStringInorder(BTNode<T> v);

/*********************************************************************
 * Method to convert the tree to a <code>String</code> in preorder.
 *
 * @param v the root node from which to traverse the tree.
 * @return the preorder <code>String</code> version of the tree.
**/
  public String toStringPreorder(BTNode<T> v);

/*********************************************************************
 * Method to convert the tree to a <code>String</code> in postorder.
 *
 * @param v the root node from which to traverse the tree.
 * @return the postorder <code>String</code> version of the tree.
**/
  public String toStringPostorder(BTNode<T> v);

} // public interface IBT
