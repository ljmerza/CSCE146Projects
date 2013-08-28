import java.util.Scanner;
/*********************************************************************
 * Interface for a class to manage records.
 *
 * Copyright(C) 2011 Duncan A. Buell. All rights reserved.
 *
 * @author Duncan Buell
 * @version 1.00 2011-03-25
**/
public interface IRecord extends Comparable<Record>
{
/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>element</code>.
 *
 * @return the value of <code>element</code>.
**/
  public String getElement();

/*********************************************************************
 * Method to set the <code>element</code>.
 *
 * @param the value of <code>element</code>.
**/
  public void setElement(String what);

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to compare the <code>element</code> values of records.
 *
 * @return -1, 0, or +1 according as the comparison goes.
**/
  public int compareTo(Record that);

/*********************************************************************
 * Method to test whether the <code>element</code> is entirely alpha.
 *
 * @return the answer to the question.
**/
  public boolean isAlpha();

/*********************************************************************
 * Method to read the flat file from an input <code>Scanner</code>.
 *
 * @return the <code>Record</code> just read.
**/
  public Record readRecord(Scanner inFile);

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 * @return the <code>String</code> value of the record.
**/
  public String toString();

} // public interface IRecord
