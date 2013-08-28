import java.util.Scanner;
/*********************************************************************
 * Class to handle a single record of process data.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-07
**/
public class ProcessInfo
{
/*********************************************************************
 * Instance variables for the class.
**/
  private static final String DUMMYSTRING = "dummy";
  private static final int DUMMYINT = Integer.MIN_VALUE;

  private String name;  /** the process name     */
  private int pid;      /** the process id       */
  private int priority; /** the process priority */

  private Key key;
/*********************************************************************
 * Constructor.
**/
  public ProcessInfo()
  {
    this.setName(ProcessInfo.DUMMYSTRING);
    this.setPid(ProcessInfo.DUMMYINT);
    this.setPriority(ProcessInfo.DUMMYINT);
    this.key = new Key(this);
  } // public ProcessInfo()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Accessor for the <code>key</code>.
 *
 * @return the value of <code>key</code>.
**/
  public Key getKey()
  {
	  return this.key;
  } // public Key getKey()

/*********************************************************************
 * Accessor for the <code>name</code>.
 *
 * @return the value of <code>name</code>.
**/
  public String getName()
  {
    return this.name;
  } // public String getName()

/*********************************************************************
 * Mutator for the <code>name</code>.
 *
 * @param what the value of <code>name</code> to be set.
**/
  private void setName(String what)
  {
    this.name = what;
  } // private void setName(String what)

/*********************************************************************
 * Accessor for the <code>pid</code>.
 *
 * @return the value of <code>pid</code>.
**/
  public int getPid()
  {
    return this.pid;
  } // public int getPid()

/*********************************************************************
 * Mutator for to set the <code>pid</code>.
 *
 * @param what the value of <code>pid</code> to be set.
**/
  private void setPid(int what)
  {
    this.pid = what;
  } // private void setPid(int what)

/*********************************************************************
 * Accessor for the <code>priority</code>.
 *
 * @return the value of <code>priority</code>.
**/
  public int getPriority()
  {
    return this.priority;
  } // public String getPriority()

/*********************************************************************
 * Mutator for the <code>priority</code>.
 *
 * @return the value of <code>priority</code>
**/
  private void setPriority(int what)
  {
    this.priority = what;
  } // private void setPriority(String what)

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to compare one instance against another.
 *
 * @return -1, 0, +1 as appropriate 
**/
  public int compareTo(ProcessInfo that)
  {		
	  int returnValue;
	  returnValue = this.key.compareTo(that.getKey());
	  return returnValue;
  } // public int compareTo()

/*********************************************************************
 * Method to read the process information from an input
 * <code>Scanner</code> file. Note that this is more or less hard
 * coded. Also that we don't bulletproof the input; among other
 * things we assume that partial records don't appear in the input.
 *
 * @param the <code>Scanner</code> from which to read.
**/
  public void readInfo(Scanner inFile)
  {
    int n;    /** local variable for input of the course number */ 
    String s; /** local variable for input of the string data   */
    
    // no bulletproofing--if *any* data exists we assume that
    // an entire record exists and in the right order and format
    if(inFile.hasNext())
    {
      n = inFile.nextInt();
      this.setPid(n);

      s = inFile.next();
      this.setName(s);

      n = inFile.nextInt();
      this.setPriority(n);

      this.key = new Key(this);
    }

  } // public void readInfo(Scanner inFile)

/*********************************************************************
 * Method to convert this instance to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the instance.
**/
  public String toString()
  {
    String s;
    s = String.format("%6d %-10s %6d",
                 this.getPid(), this.getName(), this.getPriority());
    return s;
  } // public String toString()

} // public class ProcessInfo
