import java.util.Scanner;
/*********************************************************************
 * Record class that is used in a DLL.  creates a string for a name,
 * office, courses teaching as well as a phone number for each record's 
 * instance.  Accessor and mutator methods for these attributes and a compareTo
 * to compare records and a readRecord in order to read the actual records.
 * Includes a toString method in order to convert all attributes into a
 * string and formatting into one record.
 *
 *
 * @author Duncan A. Buell modifications by Leonardo Merza
 * @version 1.00 2011-01-11
**/
public class OneLine implements Comparable<OneLine>
{
	
/*********************************************************************
 * Instance variables for the class.
**/

	private static final String DUMMYSTRING = "dummy";
	private static final int DUMMYINT = Integer.MIN_VALUE;
	private int precinct;  // the precinct number
	private int ivotronic; // the machine number
	private int binumber; // the B/I number
	private int sequence; // the sequence number
	private int totalVote; // the vote total
	private String candidate; // the candidate and contest

/*********************************************************************
 * Constructor.
**/
	public OneLine()
	{
	  this.setPrecinct(OneLine.DUMMYINT);
	  this.setIvotronic(OneLine.DUMMYINT);
	  this.setBinumber(OneLine.DUMMYINT);
	  this.setVoteTotal(OneLine.DUMMYINT);
	  this.setCandidate(OneLine.DUMMYSTRING);
	} // public OneLine()

/*********************************************************************
 * Accessors and mutators.
**/
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
	public void setPrecinct(int what)
	{
	  this.precinct = what;
	} // public void setPrecinct(int what)

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
	public void setIvotronic(int what)
	{
	  this.ivotronic = what;
	} // public void setIvotronic(int what)

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
	public void setBinumber(int what)
	{
	  this.binumber = what;
	} // public void setBinumber(int what)

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
	public void setSequence(int what)
	{
	  this.sequence = what;
	} // public void setSequence(int what)

/*********************************************************************
 * Accessor for the <code>sequence</code>.
 *
 * @return the value of <code>sequence</code>.
 **/
		public int getVoteTotal()
		{
			return this.totalVote;
	  } // public int getTotalVote()

/*********************************************************************
 * Mutator for the <code>sequence</code>.
 *
 * @param what the value of <code>sequence</code> to be set.
**/
	 public void setVoteTotal(int what)
	 {
	   this.totalVote = what;
	 } // public void setTotalVote(int what)

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
 *  
 * Mutator for the <code>candidate</code>.
**/
	public void setCandidate(String what)
	{
	  this.candidate = what;
	} // public void setCandidate(String what)

/*********************************************************************
 * General methods.
 **/
 /*********************************************************************
 * Method to compare the <code>name</code> values of records.
 * Note that we are relying here on the fact that we know that the
 * <code>name</code> is data of <code>String</code> type.
 *
 * @return -1, 0, or +1 according as the comparison goes.
 **/
	public int compareName(OneLine that)
	{
		int returnValue;

	  returnValue = 0;

	  if(this.getCandidate().compareTo(that.getCandidate()) < 0)
	  {
	    returnValue = -1;
	  } // if statement
	  else if(this.getCandidate().compareTo(that.getCandidate()) > 0)
	  {
	    returnValue = +1;
	  } // else if statement
   else
   {
     returnValue = 0;
   } // else statement

   return returnValue;
  } // public int compareName(OneLine that)

/*********************************************************************
 * Method that calls the compareName method and is used to satisfy
 * the extends Comparable class.
 *
 *@param the OneLine data that will be used to compare against.
 *
 * @return -1, 0, or +1 according as the comparison goes.
 **/
	public int compareTo(OneLine that)
	{
		int returnValue;
	  returnValue = compareName(that);
	  return returnValue;
	} // public int compareTo(OneLine that)

/*********************************************************************
 * Method to override the <code>equals</code> method.
 * We will declare two records to be equal if their data values are 
 * equal, not if they are identical objects.
 *
 * @param that the <code>Record</code> to be compared against.
 * 
 * @return boolean answer to the question.
 **/
	public boolean equals(OneLine that)
	{
	  boolean returnValue;

	  returnValue = true;

	  returnValue = returnValue && this.getPrecinct() == (that.getPrecinct());
	  returnValue = returnValue && this.getIvotronic() == (that.getIvotronic());
	  returnValue = returnValue && this.getCandidate().equals(that.getCandidate());
	  returnValue = returnValue && (this.getBinumber() == that.getBinumber());
	  returnValue = returnValue && (this.getVoteTotal() == that.getVoteTotal());

	  return returnValue;
	} // public boolean equals(OneLine that)

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
	public static OneLine readOneLine(Scanner inFile)
	{
	  int n;
	  String s;
	  OneLine newOneLine = null; 
	    
	  newOneLine = new OneLine();
	  if(inFile.hasNext())
	  {
	    n = inFile.nextInt();
	    newOneLine.setPrecinct(n);

	    n = inFile.nextInt();
	    newOneLine.setIvotronic(n);

	    n = inFile.nextInt();
	    newOneLine.setBinumber(n);

	    n = inFile.nextInt();
	    newOneLine.setSequence(n);

	    n = inFile.nextInt();
	    newOneLine.setVoteTotal(n);
	      
	    s = inFile.nextLine();
	    newOneLine.setCandidate(s);
	  } // if statement

	  return newOneLine;
	} // public OneLine readOneLine(Scanner inFile)

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the record.
**/
	public String toString()
	{
	  String s;
	  s = String.format("%4d %8d %2d %3d %4d %s%n",
	               this.getPrecinct(), this.getIvotronic(), this.getBinumber(),
	               this.getSequence(), this.getVoteTotal(), this.getCandidate());
	  return s;
	} // public String toString()
} // public class OneLine
