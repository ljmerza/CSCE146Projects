import java.util.Scanner;
/*********************************************************************
 * Class to implement a simple vote summary application.
 *
 * We read the data in and call a method to insert the new data into
 * a linked list sorted by candidate/contest.
 *
 * Rather than do the insertion in this class, we implement an
 * insertion method in the DLL code.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-10
**/
public class VoteSummary
{
/*********************************************************************
 * Instance variables for this class.
**/
//  private static final String classLabel = "VoteSummary: ";
  private DLL<OneLine> dll;

/*********************************************************************
 * Constructor.
**/
  public VoteSummary()
  {
    this.dll = new DLL<OneLine>();
  } // public VoteSummary()

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to add a <code>VoteSummary</code> entry.
 * This simply calls the DLL <code>add</code> method.  Therefore,
 * what we are really doing here is converting the <code>add</code>
 * of a <code>OneLine</code> item to the <code>VoteSummary</code> into
 * the addition of a node with that <code>OneLine</code> as data
 * payload into the <code>DLL</code>.
 *
 * @param line the <code>OneLine</code> to add.
 *
 * @return true if the list changes, else false.
**/
  public boolean add(OneLine line)
  {
    return this.dll.add(line);
  } // public boolean add(OneLine line)

/*********************************************************************
 * Method to find if a list has a given line. 
 *
 * @param line the <code>OneLine</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(OneLine line)
  {
    return this.dll.contains(line);
  } // public boolean contains(OneLine line)

/*********************************************************************
 * Method to remove a node with a given line value. 
 *
 * @param line the <code>OneLine</code> whose node is to be removed.
 *
 * @return the <code>boolean</code> that remove succeeded.
**/
  public boolean remove(OneLine line)
  {
    return this.dll.remove(line);
  } // public boolean remove(OneLine line)

/*********************************************************************
 * Method to read data from an input file.  After we read each line
 * we insert it into its appropriate location.
 *
 * @param inFile the <code>Scanner</code> from which to read.
**/
  public void readData(Scanner inFile)
  {
    while(inFile.hasNext())
    {
      OneLine line = new OneLine();
      line = line.readOneLine(inFile);
//      FileUtils.logFile.printf("VOTE: %s%n", line.toString());
//      FileUtils.logFile.flush();
      this.dll.insert(line);

//      FileUtils.logFile.printf("LIST: %s%n", this.dll.toString());
//      FileUtils.logFile.flush();

    } // while(inFile.hasNext())
  } // public void readData(Scanner inFile)

/*********************************************************************
 * Method to <code>toString</code> a complete VoteSummary.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
    String s = "";
    s = this.dll.toString();
    return s;
  } // public String toString()

} // public class VoteSummary
