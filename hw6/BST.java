import java.util.ArrayList;
import java.util.TreeMap;
/*********************************************************************
 * Class of a binary Search Tree. This class contains methods for finding
 * a record data, finding the maximum and average heights of the binary tree,
 * and displaying the data in the tree.
 *
 * Copyright(C) 2011 Duncan A. Buell. All rights reserved.
 *
 * @author Duncan Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-03-25
**/
public class BST<T extends Comparable<T>> implements IBST<T>
{
/*********************************************************************
 * Instance Variables
**/
	private final String TAG = "BST: "; // tag for BST log information
	private final int MAX_COUNT = 2000; // max count for heightCount Array
	
	private BTNode<T> root; // the root of the Binary Search Tree
	private int[] heightCount = null; // the Array that stores the height counts of each node
	private int maxHeight;
	private int nodeCount; // the count of nodes in a given height level
	private int probes; // the number of probes when searching for a record
	
	private TreeMap<Integer, Integer> counter = null; // used to keep track of the number nodes in a given height level
	
/*********************************************************************
 * Constructor
**/
	public BST()
	{
		this.root = null;
		this.heightCount = new int[MAX_COUNT];
		this.counter= new TreeMap<Integer, Integer>();
		this.maxHeight = 0;
		this.nodeCount = 0;
		this.probes = 0;
	} // public BST()
	
/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to return the average height of the tree.
 *
 * @return the average height of the tree.
**/
  public double getAverageHeight()
  {
  	return (inorderCount(0, this.root) / this.nodeCount);
  } // public double getAverageHeight()

/*********************************************************************
 * Method to return the <code>maxHeight</code> of the tree.
 *
 * @return the <code>maxHeight</code> of the tree.
**/
  public int getMaxHeight()
  {
  	return maxDepth(this.root);
  } // public int getMaxHeight()

/*********************************************************************
 * Method to return the <code>nodeCount</code> of the tree.
 *
 * @return the <code>nodeCount</code> (number of elements) in the tree.
**/
  public int getNodeCount()
  {
  	return this.nodeCount;
  } // public int getNodeCount()
  
/*********************************************************************
 * Method to return the root of the tree.
 *
 * @return the root node.
**/
  public BTNode<T> getRoot()
  {
  	return this.root;
  } // public BTNode<T> getRoot()

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to test to see if a particular data payload is in the tree. 
 *
 * @return the boolean answer to the question.
**/
  public boolean contains(T rec) 
  {
  	return(lookup(root, rec)); 
 } // public boolean contains(T rec) 

/*********************************************************************
 * Method to insert a node.
 *
 * @param rec of the node to be inserted.
 * @return the actual node that was inserted.
**/
  public BTNode<T> insert(T rec)
  {
   BTNode<T> tempNode = new BTNode<T>();
   BTNode<T> currentNode = new BTNode<T>();
   currentNode = this.root;
   tempNode.setRecord(rec);
   
   	if( this.root == null )
   	{
  	 this.root = tempNode;
   	}
   	else
   	{
   		while (currentNode.getRecord().compareTo( tempNode.getRecord() ) != 0) 
   		{
   			//if (currentNode.toString().compareTo(tempNode.toString()) < 0)
   			if (currentNode.getRecord().compareTo( tempNode.getRecord() ) < 0)
   			{
   				if (currentNode.getLeft() != null)
   				{
   					//insert(currentNode.getLeft().getRecord());
   					currentNode = currentNode.getLeft();
   				}  // if left child is not null recursively call insert
   				else
   				{
   					currentNode.setLeft(tempNode);
   					currentNode.getLeft().setParent(currentNode);
   					nodeCount++;
   					break;
   				} // else if the left child is null then add new node
   			} // if current node is smaller than the temp node go to left child
   			//else if (currentNode.toString().compareTo(tempNode.toString()) > 0)
   			else if (currentNode.getRecord().compareTo(tempNode.getRecord()) > 0)
   			{
   				if (currentNode.getRight() != null)
   				{
   					//insert(currentNode.getRight().getRecord());
   					currentNode = currentNode.getRight();
   				}  // if right child is not null, recursively call insert
   				else
   				{
    				currentNode.setRight(tempNode);
    				currentNode.getRight().setParent(currentNode);
    			  nodeCount++;
    				break;
   				} // else if the right child is null then add new node
   			} // else if current node is larger than the temp node go to the right child
   		} // while currentNode and tempNode don't match
   	} // else if the root is already used then add to binary tree
   	
   	return tempNode;
  } // public BTNode<T> insert(T rec)

/*********************************************************************
 * Method to return a boolean as to whether the tree is empty.
 *
 * @return the answer to the question.
**/
  public boolean isEmpty()
  {
  	return root == null;
  } // public boolean isEmpty()

/*********************************************************************
 * Method to convert the tree to a <code>String</code> in inorder.
 *
 * @param node the root node from which to traverse the tree.
 * @return the inorder <code>String</code> version of the tree.
**/
  public String toStringInorder(BTNode<T> node)
  {
  	this.getMaxHeight();
  	String theString = "";
  	theString = this.inorder(theString, node);
  	return theString;
  } 
  
/*********************************************************************
 * Method to convert the tree to a <code>String</code> in preorder.
 *
 * @param node the root node from which to traverse the tree.
 * @return the preorder <code>String</code> version of the tree.
**/
  public String toStringPreorder(BTNode<T> node)
  {
  	String theString = "";
  	return theString;
  } 

  /*********************************************************************
   * Method to display the number of nodes in each height level of a 
   * binary TreeMap
   * 
  **/ 
    public void writeHeightHisto() 
    {
    	ArrayList<Integer> keys = new ArrayList<Integer>(counter.keySet());
    	
    	for (Integer key : keys)
    	{
    		FileUtils.logFile.printf("%3s heightHisto[%1d] = %10d %n", TAG, key, counter.get(key) );
    	}  // for each key in the TreeMap ArrayList, display the node count in that height level
    	
    	for(int i = 174; i < this.heightCount.length; i++)
    	{
    		FileUtils.logFile.printf("%3s heightHisto[%1d] = %10d %n", TAG, i, 0 );
    	} // display the rest of the Array as level zero for the log file.
    	
    } // public void writeHeightHisto() 
    
/*********************************************************************
 * Method to convert the tree to a <code>String</code> in postorder.
 *
 * @param node the root node from which to traverse the tree.
 * @return the postorder <code>String</code> version of the tree.
**/
  public String toStringPostorder(BTNode<T> node) 
  {
  	String theString = "";
  	return theString;
  } 
 
/*********************************************************************
 * Method to find the maximum depth of a binary tree. This will print
 * out to the log file each time it finds a new max depth
 *
 * @param the BTNode that will be used as a starting point to find
 * the max depth of the tree
 * 
 * @return the Integer value of the current maximum height found.
**/
  private int maxDepth(BTNode<T> node)
  {
    if (node==null) 
    {
      return(0);
    } // if the current node is null then just return zero
    else 
    {
      int lDepth = maxDepth(node.getLeft());
      if(lDepth > this.maxHeight)
      {
      		this.maxHeight = lDepth;
      		FileUtils.logFile.printf("%s %13s %d%n", TAG, "new maxHeight", maxHeight);
      } // if the left node is bigger than the current max depth found then replace
      	//	old max height with new value and print to log file
      int rDepth = maxDepth(node.getRight());
      if(lDepth > this.maxHeight)
      {
      	this.maxHeight = lDepth;
      	FileUtils.logFile.printf("%s %13s %d%n", TAG, "new maxHeight", maxHeight);
      }// if the right node is bigger than the current max depth found then replace
    	 //	old max height with new value and print to log file
    		

      // use the larger + 1
      return(Math.max(lDepth, rDepth) + 1);
    } // if the current node is not null then continue to find max depth
  } // private int maxDepth(BTNode<T> node)

/*********************************************************************
 * Method that will display in String format the name of each node
 * and its height in inorder traversal
**/
  private String inorder(String output, BTNode<T> node)
  {
    if (node == null) 
    {
     return output;
    } // if the current node is null
        
    output = this.inorder(output, node.getRight());
    output += String.format("%20s : %4d%n",node.toString(), node.getHeight());
    output = this.inorder(output, node.getLeft());
        
    return output;
  }  // private String inorder(String output, BTNode<T> node)
  
/*********************************************************************
 * Method to add up all the heights of all the nodes in a binary tree.
 * This method will also keep track of how many nodes are in each
 * given height by using a TreeMap.
 *
 * @param the current sum of all the heights found so far
 * 
 * @param the node in the binary tree in which the user wants to start at
 * 
 * @return the sum of all the heights of all the nodes in a tree starting
 * from the given node in the parameters.
**/
  private double inorderCount(double output, BTNode<T> node)
  {
  	int currentHeight; // the height ofthe current node

  	if (node == null) 
  	{
  		return output;
  	} // if the current node is null

    if(counter.containsKey(node.getHeight()))
		{
			currentHeight = counter.get(node.getHeight());
    	counter.put(node.getHeight(), currentHeight + 1);
		} // if the current node's height is already recorded then add one to
    	// the number of nodes in that height level
		else
		{
			counter.put(node.getHeight(), 1);
		} // add a new height level and set it to one node in that height
    
    output = this.inorderCount(output, node.getRight());
    output += node.getHeight();
    output = this.inorderCount(output, node.getLeft());
          
    return output;
  }  //  private double inorderCount(double output, BTNode<T> node)
  
/*********************************************************************
 * Method to lookup a Binary Search Tree for a particular record
 * 
 * @param the node to start the search from
 * @param the T data that will be used to search with
 * 
 * @return the boolean answer if the data has been located in the 
 * binary search tree
**/
  private boolean lookup(BTNode<T> node, T data) 
  {
  	BTNode<T> findThisNode = new BTNode<T>();
  	findThisNode.setRecord(data);
	
  	if(node == null) 
  	{
  		FileUtils.logFile.printf("%s leave 'contains' after %d probes%n", TAG, probes);
  		probes = 0;
  		return false;
  	} // if the node has not been found, print the number of probes, reset probe numbers, and return false

  	if(findThisNode.getRecord().compareTo(node.getRecord()) == 0)
  	{
  		this.probes++;
  		FileUtils.logFile.printf("%s leave 'contains' after %d probes%n", TAG, probes);
  		probes = 0;
  		return true;
  	} // if the record has been found, print the number of probes, reset probe numbers, and return true
  	else if(findThisNode.getRecord().compareTo(node.getRecord()) > 0) 
  	{
  		this.probes++;
  		return lookup(node.getLeft(), data);
  	} // the current record is larger than the one being searched for then og to the left child
  	else 
  	{
  		this.probes++;
  		return lookup(node.getRight(), data);
  	} // else go to the right child
  } // private boolean lookup(BTNode<T> node, T data) 
 
} // public class BST
