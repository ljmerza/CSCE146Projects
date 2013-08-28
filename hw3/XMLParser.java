import java.util.Scanner;
/*********************************************************************
 * This class takes in data that is in XML format, assess whether or
 * not the next value is an open or close tag and compare the two 
 * in order to overall see if the data pay load is in correct XML format
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-11
**/
public class XMLParser
{
	/*********************************************************************
	 * Instance variables for this class.
	**/
	
	private Stack<String> theStack = new Stack<String>();
	private int theCounter = 1;
	private String XMLParserString = "XML Parser: ";
	private String currentlyUsedString = null;
	private String openTagStripped = null;
	private String closeTagStripped = null;
	private String data = " ";

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to take a data file that is in XML format and use a stack
 * dll to store open tags then pop the open tags when reaching a
 * close tag to compare tags to see if XML format is valid
 *
 * @param Scanner file that contains data in XML format
 * @return the <code>boolean</code> value of if the xml 
 * data pay load is valid
**/
	public boolean checkValidXML(Scanner inFile)
	{
		boolean isValid = false;
		FileUtils.logFile.printf(XMLParserString + "enter checkValidXML\n");
		while( inFile.hasNext() )//& isValid == false)
		{
			currentlyUsedString = inFile.next();
			
			if( this.isToken(currentlyUsedString) == 1)
			{
				theCounter++;
				openTagStripped = currentlyUsedString.substring(1, currentlyUsedString.length() - 1 );
				theStack.push(openTagStripped);
			} // if statement
			else if( this.isToken(currentlyUsedString) == - 1)
			{
				theCounter--;
				this.popTheTag();
				if( !(this.checkTokensEqual(openTagStripped, closeTagStripped)) )
				{
					return isValid;
				} // if statement
			} // else if statement
			else
			{
				data +=  " " + currentlyUsedString;
			} // else statement
			
		} // while loop

		if(theStack.getSize() == 2)
		{
			isValid = true;
		} // if statement
		FileUtils.logFile.printf(XMLParserString + "leave checkValidXML");
		return isValid;
	} // checkValidXML method

/*********************************************************************
 * Method to check to see if the last open tag found and the 
 * next close tag found are equal to each other in an xml data pay load
 *
 * @param the open and close tags that will be used to compare against
 * @return the <code>boolean</code> value if the tags are equal or not
**/
	private boolean checkTokensEqual(String openTagStripped, String closeTagStripped)
	{
		boolean isEqual = false;
		if( openTagStripped.equals(closeTagStripped) )
		{
			isEqual = true;
		} // if statement
		return isEqual;
	} // checkTokensEqual method
	
/*********************************************************************
 * Method to return a <code>integer</code> of whether the input data
 * is a close tag or an open tag in an xml data payload
 *
 * @return the <code>integer</code> value in which 1 means it is an
 * open tag, -1 means it is a close tag, and returning zero means
 * it is not a tag at all. 
**/
	private int isToken(String theString)
	{
		int isToken = 0;
		
		if( theString.startsWith("<") )
		{
			if ( (theString.startsWith("<")) & (theString.charAt(1) != '/') )
			{
				isToken = 1;
			} // if statement
			else if ( (theString.startsWith("<")) & (theString.charAt(1) == '/') )
			{
				isToken = - 1;
			} // if statement
		} // if statement
		else
		{
			isToken = 0;
		} //else statement
		
		return isToken;
	} // isToken method
	
/*********************************************************************
 * Method that pops the stack and strips the close tag to compare
 * the popped open tag with the stripped close tag. Will also display
 * tag number information as well as the string in between the two tags
 *
**/
	private void popTheTag()
	{
		openTagStripped = theStack.pop();
		closeTagStripped = currentlyUsedString.substring(2, currentlyUsedString.length() - 1 );
		FileUtils.logFile.printf(XMLParserString);
		for(int i = 0; i < theCounter; i++)
		{
			FileUtils.logFile.printf("X ");
		} // for loop
		FileUtils.logFile.printf("tag " + theCounter + " '" + openTagStripped + "': " + "'" + data + "' \n");
		data = " ";
	}

} // XMLParser class
