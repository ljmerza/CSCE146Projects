import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
/*********************************************************************
 * Interface for specifying the class for testing
 * set intersection and containment.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-04-02
**/
public class SetTesting
{
/*********************************************************************
 * Instance variables for the class.
 *
 * THESE ARE COMMENTED OUT FOR THE MOMENT
**/
  private int intersectionCount;
  private int subsetCount;
  private int testCount;
  private HashSet<String> controlSet = null;

/*********************************************************************
 * Constructor.
**/
  public SetTesting()
  {
	  this.intersectionCount = 0;
	  this.subsetCount = 0;
	  this.testCount = 0;
	  controlSet = new HashSet<String>();
  }
/*********************************************************************
 * Accessors and mutators.
 * 
**/
/*********************************************************************
 * Method <code>getIntersectionCount</code> to return that value.
**/
  public int getIntersectionCount()
  {
	  return this.intersectionCount;
  }

/*********************************************************************
 * Method <code>getSubsetCount</code> to return that value.
**/
  public int getSubsetCount()
  {
	  return this.subsetCount;
  }

/*********************************************************************
 * Method <code>getTestCount</code> to return that value.
**/
  public int getTestCount()
  {
	  return this.testCount;
  }

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to read the <code>controlSet</code>.
 *
 * @param inFile the file to read from.
**/
  public void readControlSet(Scanner inFile)
  {
	String theString = "";
		  
	while( (inFile.hasNext()) )
	{
		theString = inFile.next();
		if( !(theString.equals("SETEND")) )
		{
			this.controlSet.add(theString);
		}
	}
	  
  } // public void readControlSet(Scanner inFile)

/*********************************************************************
 * Method to read one set.
 *
 * @param inFile the file to read from.
**/
  public HashSet<String> readOneSet(Scanner inFile)
  {
	HashSet<String> tempSet = new HashSet<String>();
	
	String theString = "";
	
	theString = inFile.next();
	
	while( !(theString.equals("SETEND")) )
	{
		tempSet.add(theString);
		theString = inFile.next();
	}
	
	this.testCount++;
	
	return tempSet;
  }

/*********************************************************************
 * Method to test a set for intersection/containment.
 *
 * @param what the set to test.
**/
  public void testInclusion(HashSet<String> theSet)
  {
	 int tempSize = 0;
	Iterator<String> iter = theSet.iterator();
	
	while(iter.hasNext())
	{
		String s = iter.next();
		
		if(controlSet.contains(s))
		{
			tempSize++;
		}
	}
	
	if(theSet.size() == tempSize)
	{
		this.subsetCount++;
	}
	if(tempSize > 0)
	{
		this.intersectionCount++;
	}

	
  }

/*********************************************************************
 * Method to read and test the sets for intersection/containment.
 *
 * @param inFile the file to read from.
**/
  public void testTheSets(Scanner inFile)
  {
	  HashSet<String> tempSet = new HashSet<String>();
	  
	  while( inFile.hasNext() )
	  {
			  tempSet = this.readOneSet(inFile);
			  this.testInclusion(tempSet);
	  }

  }

} //
