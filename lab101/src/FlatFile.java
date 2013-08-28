import java.util.Scanner;
/*********************************************************************
 * Copyright (C) 2008 by Duncan A. Buell.  All rights reserved.
 * Class for handling activity at the level of the flat file.
 *
 * @author Duncan A. Buell
 * @version 1.00 2008-12-15
**/
public class FlatFile
{
/*********************************************************************
 * Instance variables.
**/
  static final String classLabel = "FlatFile: "; // for debugging
  static final int DEFAULT_SIZE = 20;

  private int size;      /** the number of items actually in play */
  private Record[] recs; /** the array of data items              */

/*********************************************************************
 * Default constructor.
 * Initialize the array with a default size and set <code>size</code>
 * to zero.
**/
  public FlatFile()
  {
    this.recs = new Record[FlatFile.DEFAULT_SIZE];
    this.setSize(0);
  } // public FlatFile()

/*********************************************************************
 * Constructor.
 * Initialize the array to an input number of locations and set
 * <code>size</code> to zero.
 *
 * @param howMany the number of array locations to allow for.
**/
  public FlatFile(int howMany)
  {
    this.recs = new Record[howMany];
    this.setSize(0);
  } // public FlatFile(int howMany)

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Accessor method to get an individual <code>Record</code>.
 *
 * @param which the subscript of the <code>Record</code> to retrieve.
 *
 * @return the <code>Record</code>.
**/
  public Record getRecord(int which)
  {
    return this.recs[which];
  } // public Record getRecord(int which)

/*********************************************************************
 * Mutator method to set an individual <code>Record</code>.
 *
 * @param which the subscript of the <code>Record</code> to set.
 * @param what <code>Record</code> to insert into the array.
**/
  public void setRecord(int which, Record what)
  {
    if( (which < 0) || (which > this.recs.length) )
    {
      String s = String.format("subscript %d out of bounds ", which);
      s += String.format("for array of length %d%n", this.recs.length);
      throw new RuntimeException(s);
    }
    else
    {
      this.recs[which] = what;
    }
  } // public void setRecord(int which, Record what)

/*********************************************************************
 * Accessor for <code>size</code>.
 *
 * @return the <code>size</code>.
**/
  public int getSize()
  {
    return this.size;
  } // public int getSize()

/*********************************************************************
 * Mutator for <code>size</code>.
 *
 * @param size the value to be set for <code>size</code>.
**/
  public void setSize(int size)
  {
    if( (size < 0) || (size > this.recs.length) )
    {
      String s = String.format("size %d out of bounds ", size);
      s += String.format("for array of length %d%n", this.recs.length);
      throw new RuntimeException(s);
    }
    else
    {
      this.size = size;
    }
  } // public void setSize(int size)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to find a name in the file.
 *
 * @param name the <code>name</code> for which to search.
 *
 * @return the subscript of the record if found, or -1 if not there.
**/
  public int findName(String searchName)
  {
    int returnValue;
    int probeCount; /** number of probes made */

    returnValue = -1;

    probeCount = 0;
    for(int i = 0; i < this.getSize(); ++i)
    {
      ++probeCount;
      if(this.getRecord(i).getName().equals(searchName))
      {
        FileUtils.logFile.printf("%s found '%s' after %d probes%n",
                                 classLabel, searchName, probeCount);
        returnValue = i;
      }
    }

    if(returnValue < 0)
    {
      FileUtils.logFile.printf("%s did not find '%s' after %d probes%n",
                               classLabel, searchName, probeCount);
    }
    return returnValue;
  } // public int findName(String searchName)

/*********************************************************************
 * Method to read the file from an input <code>Scanner</code> file.
 *
 * @param inFile the <code>Scanner</code> from which to read.
 *
 * @return the <code>FlatFile</code> that was read.
**/
  public FlatFile readFile(Scanner inFile)
  {
    int sub;
    Record rec = null;

    sub = 0;
    while(inFile.hasNext())
    {
      rec = Record.readRecord(inFile);

      this.setRecord(sub, rec);

      ++sub;
      if(sub >= this.recs.length)
      {
        System.out.printf("Array limit of %d has been reached.",
                           this.recs.length);
        System.out.printf("  Read terminated.%n");
        break; // we will violate rules and break here 
      }
    }

    this.setSize(sub);

    return this;
  } // public FlatFile readFile(Scanner inFile)

/*********************************************************************
 * Method to convert an entire <code>FlatFile</code> to a
 * <code>String</code>.  Note that there is no newline at the end of
 * the string.
 *
 * @return the <code>String</code> value of the <code>FlatFile</code>.
**/
  public String toString()
  {
    String s = "";

    if(0 == this.getSize())
    {
      s = String.format("%nFile is empty.");
    }
    else
    {
      for(int i = 0; i < this.getSize(); ++i)
      {
        s += String.format("%nsubscript %d %s",
                           i, this.getRecord(i).toString());
      }
    }

    return s;
  } // public String toString()

} // public class FlatFile
