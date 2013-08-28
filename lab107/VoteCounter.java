import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Intermediate class for counting votes in Lab 07 and HW 5.
 *
 * For the lab, we read votes into an <code>ArrayList</code>,
 * insert into proper order as the data comes in, and then count.
 * votes by running loops.
 *
 * For the HW, this will be done with a <code>TreeMap</code>.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-03-03
**/
public class VoteCounter
{
/*********************************************************************
 * Instance variables for the class.
**/
  private final String TAG = "VoteCounter: ";

  private ArrayList<OneLine> theList;

/*********************************************************************
 * Constructor.
**/
  public VoteCounter()
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
 * Method to count the votes the hard way.
 * This is standard breakpoint processing. 
 * 
 * 
 * @param outFile the output file to which to write
**/
  private void countTheVotes(PrintWriter outFile)
  {
    int ballotsCast = 0;
    int theCount = 0;

    String newContest = "";
    String newCandidate = "";
    String oldContest = "";
    String oldCandidate = "";

    OneLine theLine;

    for(int i = 0; i < this.theList.size(); ++i)
    {
      theLine = this.theList.get(i);
      if(theLine.isNewBallot())
      {
        ++ballotsCast;
      }
    }
    outFile.printf("A total of %6d ballots were cast.%n", ballotsCast);

    theLine = new OneLine();
    theCount = 0;
    for(int i = 0; i < this.theList.size(); ++i)
    {
      theLine = this.theList.get(i);
      newContest = theLine.getContest();
      newCandidate = theLine.getCandidate();
      if(newContest.compareTo(oldContest) != 0) // breakpoint
      {
        outFile.printf("%40s %40s %6d%n",
                        oldContest, oldCandidate, theCount);
        oldCandidate = newCandidate;
        oldContest = newContest;
        theCount = 0;
      }
      else if(newCandidate.compareTo(oldCandidate) != 0) // breakpoint
      {
        outFile.printf("%40s %40s %6d%n",
                        oldContest, oldCandidate, theCount);
        oldCandidate = newCandidate;
        oldContest = newContest;
        theCount = 0;
      }
      ++theCount;
    }

    outFile.printf("%40s %40s %6d%n",
                    oldContest, oldCandidate, theCount);
  } // private void insertionSort()

/*********************************************************************
 * Method to do the work for the lab assignment.
 * We read a line of data, add it to the list, then insertionsort it
 * into place.
 *
 * After reading in all the data, we count the votes.
 *
 * @param inFile the <code>Scanner</code> from which to read data.
 * @param outFile the <code>PrintWriter</code> to which to write.
**/
  public void doTheWork(Scanner inFile, PrintWriter outFile)
  {
    while(inFile.hasNext())
    {
      OneLine line = new OneLine();
      line = line.readLine(inFile);
      this.theList.add(line);
      this.pullLineForward(this.theList.size()-1);
    }

    outFile.printf("%s", this.toString());

    this.countTheVotes(outFile);

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
 *
 * @param fromWhere the subscript whose value is to be pulled into place
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
