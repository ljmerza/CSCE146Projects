import java.util.Scanner;
/*********************************************************************
 * Class to handle one line of vote data for Lab 07 and HW 5.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-03-03
**/
public class OneLine
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private final String TAG = "OneLine: "; // for debugging

  private static final String DUMMYSTRING = "dummy";
  private static final int DUMMYINT = Integer.MIN_VALUE;

  private boolean newBallot;  // is this a new ballot?

  private int precinct;  // the precinct number
  private int ivotronic; // the machine number
  private int binumber; // the B/I number
  private int sequence; // the sequence number
  private int voteCount; // the vote count

  private String candidate; // the candidate
  private String contest; // the contest

/*********************************************************************
 * Constructor.
**/
  public OneLine()
  {
    this.setNewBallot(false);
    this.setPrecinct(OneLine.DUMMYINT);
    this.setIvotronic(OneLine.DUMMYINT);
    this.setBinumber(OneLine.DUMMYINT);
    this.setSequence(OneLine.DUMMYINT);
    this.setVoteCount(OneLine.DUMMYINT);

    this.setCandidate(OneLine.DUMMYSTRING);
    this.setContest(OneLine.DUMMYSTRING);
  } // public OneLine()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Accessor for the <code>binumber</code>.
 *
 * @return the value of <code>binumber</code>.
**/
  public int getBinumber()
  {
    return this.binumber;
  } // public int getBinumber()

/*********************************************************************
 * Mutator for the <code>binumber</code>.
 *
 * @param what the value of <code>binumber</code> to be set.
**/
  private void setBinumber(int what)
  {
    this.binumber = what;
  } // private void setBinumber(int what)

/*********************************************************************
 * Accessor for the <code>candidate</code>.
 *
 * @return the value of <code>candidate</code>.
**/
  public String getCandidate()
  {
    return this.candidate;
  } // public String getCandidate()

/*********************************************************************
 * Mutator for the <code>candidate</code>.
 *
 * @return the value of <code>candidate</code>
**/
  private void setCandidate(String what)
  {
    this.candidate = what;
  } // private void setCandidate(String what)

/*********************************************************************
 * Accessor for the <code>contest</code>.
 *
 * @return the value of <code>contest</code>.
**/
  public String getContest()
  {
    return this.contest;
  } // public String getContest()

/*********************************************************************
 * Mutator for the <code>contest</code>.
 *
 * @return the value of <code>contest</code>
**/
  private void setContest(String what)
  {
    this.contest = what;
  } // private void setContest(String what)

/*********************************************************************
 * Accessor for the <code>ivotronic</code>.
 *
 * @return the value of <code>ivotronic</code>.
**/
  public int getIvotronic()
  {
    return this.ivotronic;
  } // public int getIvotronic()

/*********************************************************************
 * Mutator for the <code>ivotronic</code>.
 *
 * @param what the value of <code>ivotronic</code> to be set.
**/
  private void setIvotronic(int what)
  {
    this.ivotronic = what;
  } // private void setIvotronic(int what)

/*********************************************************************
 * Accessor for the <code>newBallot</code>.
 *
 * @return the value of <code>newBallot</code>.
**/
  public boolean isNewBallot()
  {
    return this.newBallot;
  } // public boolean isNewBallot()

/*********************************************************************
 * Mutator for the <code>newBallot</code>.
 *
 * @param what the value of <code>newBallot</code> to be set.
**/
  private void setNewBallot(boolean what)
  {
    this.newBallot = what;
  } // private void setNewBallot(boolean what)

/*********************************************************************
 * Accessor for the <code>precinct</code>.
 *
 * @return the value of <code>precinct</code>.
**/
  public int getPrecinct()
  {
    return this.precinct;
  } // public int getPrecinct()

/*********************************************************************
 * Mutator for the <code>precinct</code>.
 *
 * @param what the value of <code>precinct</code> to be set.
**/
  private void setPrecinct(int what)
  {
    this.precinct = what;
  } // private void setPrecinct(int what)

/*********************************************************************
 * Accessor for the <code>sequence</code>.
 *
 * @return the value of <code>sequence</code>.
**/
  public int getSequence()
  {
    return this.sequence;
  } // public int getSequence()

/*********************************************************************
 * Mutator for the <code>sequence</code>.
 *
 * @param what the value of <code>sequence</code> to be set.
**/
  private void setSequence(int what)
  {
    this.sequence = what;
  } // private void setSequence(int what)

/*********************************************************************
 * Accessor for the <code>voteCount</code>.
 *
 * @return the value of <code>voteCount</code>.
**/
  public int getVoteCount()
  {
    return this.voteCount;
  } // public int getVoteCount()

/*********************************************************************
 * Mutator for the <code>voteCount</code>.
 *
 * @param what the value of <code>voteCount</code> to be set.
**/
  private void setVoteCount(int what)
  {
    this.voteCount = what;
  } // private void setVoteCount(int what)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Standard comparison method.
 * This compares the <code>contest</code> and <code>candidate</code>
 * instance variables, in that order.  This is <code>String</code>
 * data, and comparison is done as such. 
 *
 * @return -1, 0, or 1 according as the comparison goes.
**/
  public int compareTo(OneLine that)
  {
    int returnValue;

    returnValue = 0;
    if(this.getContest().compareTo(that.getContest()) < 0)
    {
      returnValue = -1;
    }
    else if(this.getContest().compareTo(that.getContest()) > 0)
    {
      returnValue = +1;
    }
    else
    {
      if(this.getCandidate().compareTo(that.getCandidate()) < 0)
      {
        returnValue = -1;
      }
      else if(this.getCandidate().compareTo(that.getCandidate()) > 0)
      {
        returnValue = +1;
      }
      else
      {
        returnValue = 0;
      }
    }
    return returnValue;
  } // public int compareTo(OneLine that)

/*********************************************************************
 * Method to read the <code>OneLine</code> from an input
 * <code>Scanner</code> file. Note that this is more or less hard
 * coded. Also that we don't bulletproof the input; among other
 * things we assume that partial records don't appear in the input.
 *
 * @param the <code>Scanner</code> from which to read.
 *
 * @return the <code>Scanner</code> from which to read.
**/
  public OneLine readLine(Scanner inFile)
  {
    int n;
    String s;
    OneLine newOneLine = null; // the value returned
    
    newOneLine = new OneLine();
    if(inFile.hasNext())
    {
      s = inFile.next().trim();
      if(0 == s.compareTo("T"))
      {
        newOneLine.setNewBallot(true);
      }
      else 
      {
        newOneLine.setNewBallot(false);
      }

      n = inFile.nextInt();
      newOneLine.setPrecinct(n);

      n = inFile.nextInt();
      newOneLine.setIvotronic(n);

      n = inFile.nextInt();
      newOneLine.setBinumber(n);

      n = inFile.nextInt();
      newOneLine.setSequence(n);

      n = inFile.nextInt(); // we read a zero vote count
      newOneLine.setVoteCount(n);

      s = inFile.next();
      newOneLine.setCandidate(s);

      s = inFile.next();
      newOneLine.setContest(s);
    }

    return newOneLine;
  } // public OneLine readOneLine(Scanner inFile)

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 *
 * We dump everything except the vote count, which is assumed to be
 * not a valid number at this
 *
 * @return the formatted <code>String</code> value of the record.
**/
  public String toString()
  {
    String s;

    s = "";
    if(this.isNewBallot())
    {
      s += "*";
    }
    else
    {
      s += " ";
    }

    s += String.format("%5d %9d %5d %5d %6d %s %s%n",
                 this.getPrecinct(), this.getIvotronic(), this.getBinumber(),
                 this.getSequence(), this.getVoteCount(), this.getCandidate(),
                 this.getContest());
    return s;
  } // public String toString()

} // public class OneLine
