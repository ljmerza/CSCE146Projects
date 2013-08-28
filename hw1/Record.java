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
public class Record implements Comparable<Record>
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private final String classLabel = "Record: "; // for debugging

  private static final String DUMMYSTRING = "dummy";
  private static final int DUMMYINT = Integer.MIN_VALUE;
  private int teaching;  /** the course number being taught */
  private String name;   /** the last name                  */
  private String office; /** the office 'number'            */
  private String phone;  /** the phone 'number'             */

/*********************************************************************
 * Constructor.
**/
  public Record()
  {
    this.setName(Record.DUMMYSTRING);
    this.setOffice(Record.DUMMYSTRING);
    this.setPhone(Record.DUMMYSTRING);
    this.setTeaching(Record.DUMMYINT);
  } // public Record()

/*********************************************************************
 * Accessors and mutators.
**/
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
  public void setName(String what)
  {
    this.name = what;
  } // public void setName(String what)

/*********************************************************************
 * Accessor for the <code>office</code>.
 *
 * @return the value of <code>office</code>.
**/
  public String getOffice()
  {
    return this.office;
  } // public String getOffice()

/*********************************************************************
 * Mutator for to set the <code>office</code>.
 *
 * @param what the value of <code>name</code> to be set.
**/
  public void setOffice(String what)
  {
    this.office = what;
  } // public void setOffice(String what)

/*********************************************************************
 * Accessor for the <code>phone</code>.
 *
 * @return the value of <code>phone</code>.
**/
  public String getPhone()
  {
    return this.phone;
  } // public String getPhone()

/*********************************************************************
 * Mutator for the <code>phone</code>.
 *
 * @return the value of <code>phone</code>
**/
  public void setPhone(String what)
  {
    this.phone = what;
  } // public void setPhone(String what)

/*********************************************************************
 * Accessor for the <code>teaching</code>.
 *
 * @return the value of <code>teaching</code>.
**/
  public int getTeaching()
  {
    return this.teaching;
  } // public int getTeaching()

/*********************************************************************
 * Mutator for the <code>teaching</code>.
 *
 * @return the value of <code>teaching</code>
**/
  public void setTeaching(int what)
  {
    this.teaching = what;
  } // public void setTeaching(int what)

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
  public int compareName(Record that)
  {
    int returnValue;

    returnValue = 0;

    // we fudge a little here in this early program and assume
    // that we are comparing 'String' data for the 'name'
    if(this.getName().compareTo(that.getName()) < 0)
    {
      returnValue = -1;
    }
    else if(this.getName().compareTo(that.getName()) > 0)
    {
      returnValue = +1;
    }
    else
    {
      returnValue = 0;
    }

    return returnValue;
  } // public int compareName(Record that)

/*********************************************************************
 * Method to compare the <code>name</code> values of records.
 * Note that we are relying here on the fact that we know that the
 * <code>name</code> is data of <code>String</code> type.
 *
 * @return -1, 0, or +1 according as the comparison goes.
**/
  public int compareTo(Record that)
  {
    int returnValue;

    returnValue = 0;

    if(this.getName().compareTo(that.getName()) < 0)
    {
      returnValue = -1;
    }
    else if(this.getName().compareTo(that.getName()) > 0)
    {
      returnValue = +1;
    }
    else
    {
      returnValue = 0;
    }

    return returnValue;
  } // public int compareTo(Record that)

/*********************************************************************
 * Method to override the <code>equals</code> method.
 * We will declare two records to be equal if their data values are 
 * equal, not if they are identical objects.
 *
 * @param that the <code>Record</code> to be compared against.
 * 
 * @return boolean answer to the question.
**/
  public boolean equals(Record that)
  {
    boolean returnValue;

    returnValue = true;

    returnValue = returnValue && this.getName().equals(that.getName());
    returnValue = returnValue && this.getOffice().equals(that.getOffice());
    returnValue = returnValue && this.getPhone().equals(that.getPhone());
    returnValue = returnValue && (this.getTeaching() == that.getTeaching());

    return returnValue;
  } // public boolean equals(Record that)

/*********************************************************************
 * Method to read the <code>Record</code> from an input
 * <code>Scanner</code> file. Note that this is more or less hard
 * coded. Also that we don't bulletproof the input; among other
 * things we assume that partial records don't appear in the input.
 *
 * @param the <code>Scanner</code> from which to read.
 *
 * @return the <code>Scanner</code> from which to read.
**/
  public static Record readRecord(Scanner inFile)
  {
    int n;    /** local variable for input of the course number */
    String s; /** local variable for input of the string data   */
    Record newRecord = null; /** the value returned             */
    
    // no bulletproofing--if *any* data exists we assume that
    // an entire record exists and in the right order and format
    newRecord = new Record();
    if(inFile.hasNext())
    {
      s = inFile.next();
      newRecord.setName(s);

      s = inFile.next();
      newRecord.setOffice(s);

      s = inFile.next();
      newRecord.setPhone(s);

      n = inFile.nextInt();
      newRecord.setTeaching(n);
    }

    return newRecord;
  } // public static Record readRecord(Scanner inFile)

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the record.
**/
  public String toString()
  {
    String s;
    s = String.format("%-10s %-5s %-9s %4d",
                 this.getName(),this.getOffice(),
                 this.getPhone(),this.getTeaching());
    return s;
  } // public String toString()

} // public class Record
