import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Intermediate class for managing the list in Lab 04.
 *
 * This is the version in which we read the data one line at a time
 * and insert into proper order as the data comes in.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-02
**/
public class ManagedList
{
/*********************************************************************
 * Instance variables for the class.
**/
  private final String classLabel = "ManagedList: ";

  private ArrayList<OneLine> theList;

/*********************************************************************
 * Constructor.
**/
  public ManagedList()
  {
    theList = new ArrayList<OneLine>();
  }

/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to do the work for the lab assignment.
 *
 * @param s the <code>Scanner</code> from which to read data.
**/
  public void doTheWork(Scanner inFile, PrintWriter outFile)
  {
    // read the data and fill the arraylist 
    // and sort on the fly
    while(inFile.hasNext())
    {
      OneLine line = new OneLine();
      line = line.readLine(inFile);
      this.theList.add(line);
      this.pullLineForward(this.theList.size()-1);
    }

    // then print
    outFile.printf("%s", this.toString());

  } // public void doTheWork(Scanner inFile, PrintWriter outFile)

/*********************************************************************
 * Method to do a complete insertionsort on the <code>ArrayList</code>.
**/
  private void insertionSort()
  {
    for(int i = 1; i < this.theList.size(); ++i)
    {
      this.pullLineForward(i);
    }
  } // private void insertionSort()

/*********************************************************************
 * Method to pull one element in the list forward until it is in the
 * proper location.
**/
  private void pullLineForward(int fromWhere)
  {
    for(int j = fromWhere; j >= 1; --j)
    {
      if(this.theList.get(j).compareTo(this.theList.get(j-1)) < 0)
      {
        OneLine temp = new OneLine();
        temp = this.theList.get(j);
        this.theList.set(j, this.theList.get(j-1));
        this.theList.set(j-1, temp);
      }
    }
  } // private void pullLineForward(int fromWhere)

/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the standard return from a <code>toString</code>.
**/
  public String toString()
  {
    String s = "";

    for(OneLine line: theList)
    {
      s += line.toString();
    }

    return s;
  } // public String toString()

} // public class ManagedList
