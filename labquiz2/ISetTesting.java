import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
/*********************************************************************
 * Interface for specifying the class for testing
 * set intersection and containment.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-04-02
**/
public interface ISetTesting
{
/*********************************************************************
 * Instance variables for the class.
 *
 * THESE ARE COMMENTED OUT FOR THE MOMENT
**/
//  private int intersectionCount;
//  private int subsetCount;
//  private int testCount;
//  private HashSet<String> controlSet;

/*********************************************************************
 * Constructor.
 *
 * YOU WILL NEED A CONSTRUCTOR.
**/

/*********************************************************************
 * Accessors and mutators.
 * YOU WILL NOT NEED MUTATORS.
**/
/*********************************************************************
 * Method <code>getIntersectionCount</code> to return that value.
**/
  public int getIntersectionCount();

/*********************************************************************
 * Method <code>getSubsetCount</code> to return that value.
**/
  public int getSubsetCount();

/*********************************************************************
 * Method <code>getTestCount</code> to return that value.
**/
  public int getTestCount();

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to read the <code>controlSet</code>.
 *
 * @param inFile the file to read from.
**/
  public void readControlSet(Scanner inFile);

/*********************************************************************
 * Method to read one set.
 *
 * @param inFile the file to read from.
**/
  public HashSet<String> readOneSet(Scanner inFile);

/*********************************************************************
 * Method to test a set for intersection/containment.
 *
 * @param what the set to test.
**/
  public void testInclusion(HashSet<String> theSet);

// FOR A HOMEWORK EXERCISE I WOULD EXPECT YOU TO BE ABLE TO LOOK
// THIS UP, BUT FOR A LAB QUIZ I WILL GIVE YOU THE BASIC STRUCTURE
// OF AN ITERATOR OVER A HASHSET.  IT IS THE FOLLOWING LOOP CODE
// AND LOOKS JUST LIKE THE SCANNER.
// NOTE THAT YOU WILL NEED TO IMPORT THE ITERATOR.
//   Iterator<String> iter = theSet.iterator();
//    while(iter.hasNext())
//    {
//      String s = iter.next();
//      YOUR CODE GOES HERE
//    }

/*********************************************************************
 * Method to read and test the sets for intersection/containment.
 *
 * @param inFile the file to read from.
**/
  public void testTheSets(Scanner inFile);

} //
