import java.util.Scanner;
import java.util.ArrayList;
/*********************************************************************
 * Class to manage records for a binary search tree.
 *
 * @author Duncan Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-03-25
**/
public class Record implements IRecord
{
/*********************************************************************
 * Instance Variables
**/
	private String element;
	private ArrayList<String> nonAlphaElements;
	
/*********************************************************************
 * Constructor
**/
	public Record()
	{
		this.element = null;
		this.nonAlphaElements = new ArrayList<String>();
		nonAlphaElements.add(".");
		nonAlphaElements.add("0");
		nonAlphaElements.add("1");
		nonAlphaElements.add("2");
		nonAlphaElements.add("3");
		nonAlphaElements.add("4");
		nonAlphaElements.add("5");
		nonAlphaElements.add("6");
		nonAlphaElements.add("7");
		nonAlphaElements.add("8");
		nonAlphaElements.add("`");
		nonAlphaElements.add("/");
		nonAlphaElements.add(",");
		nonAlphaElements.add("(");
		nonAlphaElements.add(")");
		nonAlphaElements.add("-");
		nonAlphaElements.add("&");
		nonAlphaElements.add(";");
		nonAlphaElements.add(":");
		nonAlphaElements.add("\"");
		nonAlphaElements.add("\\");
		nonAlphaElements.add("'");
		nonAlphaElements.add("<");
		nonAlphaElements.add(">");
		nonAlphaElements.add("â");
		
	} // public Record()
	
/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>element</code>.
 *
 * @return the value of <code>element</code>.
**/
  public String getElement()
  {
  	return this.element;
  } // public String getElement()

/*********************************************************************
 * Method to set the <code>element</code>.
 *
 * @param the value of <code>element</code>.
**/
  public void setElement(String what)
  {
  	this.element = what;
  } // public void setElement(String what)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to compare the <code>element</code> values of records.
 *
 * @return -1, 0, or +1 according as the comparison goes.
**/
  public int compareTo(Record that)
  {
    int returnValue;
    returnValue = 0;

    if(this.getElement().compareTo(that.getElement()) < 0)
    {
      returnValue = -1;
    } // if statement
    else if(this.getElement().compareTo(that.getElement()) > 0)
    {
      returnValue = +1;
    } // else if statement
    else
    {
      returnValue = 0;
    } // else statement

    return returnValue;
  } // public int compareTo(Record that)

/*********************************************************************
 * Method to test whether the <code>element</code> is entirely alpha.
 *
 * @return the answer to the question.
**/
  public boolean isAlpha()
  {
  	boolean isAlpha = true;
  	String theString;
  	
  	for(int i = 0; i < this.nonAlphaElements.size(); i++)
  	{
  		theString = this.nonAlphaElements.get(i);
  		if( (this.element.contains(theString)) )
  		{
  			isAlpha = false;
  		} // the the current element in this object contains a char of the nonAlpha
  	} // continue searching for nonAlpha letters until searched through entire nonAlpha Array
  	
  	return isAlpha;
  } // public boolean isAlpha()

/*********************************************************************
 * Method to read the flat file from an input <code>Scanner</code>.
 *
 * @return the <code>Record</code> just read.
**/
  public Record readRecord(Scanner inFile)
  {
  	String newElement;
  	Record newRecord = null;
  	newRecord = new Record();
  	
  	if(inFile.hasNext())
  	{
  		newElement = inFile.next();
  		element = newElement.toLowerCase();
    	newRecord.setElement(element);    	
  	} // if(inFile.hasNext())
  	
  	return newRecord;
  } // public Record readRecord(Scanner inFile)

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 * @return the <code>String</code> value of the record.
**/
  public String toString()
  {
    return this.getElement();
  } // public String toString()

} // public class IRecord
