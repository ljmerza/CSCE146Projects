import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
/*********************************************************************
 * Lab 8: Building a tree
 * This code is for building a tree and demonstrating the use of 
 * of tree traversal.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza
 * @version 1.00 2011-03-16
**/
public class TreeClass
{
	private ArrayList<String> theList = null;
/*********************************************************************
 * Instance variables for this class.
**/
	
/*********************************************************************
 * Constructor.
**/
	public TreeClass()
	{
		this.theList = new ArrayList<String>();
	}
	
/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the left child of a treemap
**/
	private int getLeftChild(int index)
	{
		return index * 2;
	} // private int getLeftChild(int index)
	
/*********************************************************************
 *  Method to get the right child of a treemap
**/
	private int getRightChild(int index)
	{
		return ((index * 2) + 1);
	} // private int getRightChild(int index)
	
/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to read a file and store each value in a <code>String</code>
 * format into an ArrayList.
 * 
 * @param the Scanner file that will be used to read from
**/
	public void buildTree(Scanner inFile)
	{
		this.theList.add("DUMMY");
		while( inFile.hasNext() )
		{
			String theString;
			theString = inFile.next();
			this.theList.add(theString);
		} // while(inFile.hasNext())
		
	} // public void buildTree(PrintWriter inFile)
/*********************************************************************
 * Method to create a preorder transversal of an arraylist
 * 
 * @param the string that will be used to create the list
 * @param the beginning index where the tranversal will start
**/
	public String toStringPreorderTraversal(String output, int index)
	{
		 if( !(index < this.theList.size() && index > 0) )
		 {
			 return output;
		 } // if index is larger than the arraylist size or index < 0
		 
			output += this.theList.get(index) + " ";
			output = this.toStringPreorderTraversal(output, this.getLeftChild(index));
			output = this.toStringPreorderTraversal(output, this.getRightChild(index));

		return output;
	} // public String toStringPreorderTraversal(String output, int tempInt)
		
/*********************************************************************
 * Method to create a postorder transversal of an arraylist
 * 
 * @param the string that will be used to create the list
 * @param the beginning index where the tranversal will start
**/
	public String toStringPostorderTraversal(String output, int index)
	{
		 if( !(index < this.theList.size() && index > 0) )
		 {
			 return output;
		 } // if index is larger than the arraylist size or index < 0
		 
		output = this.toStringPostorderTraversal(output, this.getLeftChild(index));
		output = this.toStringPostorderTraversal(output, this.getRightChild(index));
		output += this.theList.get(index) + " ";

		return output;
	} // public String toStringPostorderTraversal(String output, int tempInt)
			
/*********************************************************************
 * Method to create an inorder transversal of an arraylist
 * 
 * @param the string that will be used to create the list
 * @param the beginning index where the tranversal will start
**/
	public String toStringInorderTraversal(String output, int index)
	{
		 if( !(index < this.theList.size() && index > 0) )
		 {
			 return output;
		 } // if index is larger than the arraylist size or index < 0
		 
		output = this.toStringInorderTraversal(output, this.getLeftChild(index));
		output += this.theList.get(index) + " ";
		output = this.toStringInorderTraversal(output, this.getRightChild(index));

		return output;
	} // public String toStringInorderTraversal(String output, int tempInt)
				
/*********************************************************************
 * Standard <code>toString</code> method
 *
 * @return the <code>String</code> of an entire arraylist
**/
	  public String toString()
	  {
	    String theString = "";

	    for(String temp : this.theList)
	    {
	    	theString += temp + " ";
	    } // for each value in theList add to theString
	    return theString;
	  } // public String toString()
	  
} // public class TreeClass

