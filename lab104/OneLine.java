import java.util.Scanner;
/*********************************************************************
 * Class to handle one line of voter input data.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza
 * @version 1.00 2011-01-25
**/
public class OneLine
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private final String classLabel = "OneLine: "; // for debugging

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
 * Mutator for the <code>candidate</code>.
 *
 * @return the value of <code>candidate</code>
**/
  public void setCandidate(String what)
  {
    this.candidate = what;
  } // public void setCandidate(String what)

/*********************************************************************
 * General methods.
**/
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
  public OneLine readOneLine(Scanner inFile)
  {
    int n;
    String s;
    OneLine newOneLine = null; // the value returned
    
    // no bulletproofing--if *any* data exists we asssume that
    // an entire record exists and in the right order and format
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
    }

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
    s = String.format("%d  %d  %d  %d  %d%s%n",
                 this.getPrecinct(), this.getIvotronic(), this.getBinumber(),
                 this.getSequence(), this.getVoteTotal(), this.getCandidate());
    return s;
  } // public String toString()
  
/*********************************************************************
 * Standard comparison method.
 * This compares the <code>candidate</code> instance variables.
 *
 * @return -1, 0, or 1 according as the comparison goes.
**/
  public int compareTo(OneLine that)
  {
    return this.getCandidate().compareTo(that.getCandidate());
  } // public int compareTo(OneLine that)
  
} // public class OneLine
