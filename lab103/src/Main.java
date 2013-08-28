/*********************************************************************
 * Class to read an xml file and output it into a format that
 * seperates the tags and the data in a new file.
 *
 * @author Leonardo Merza
 * @version 1.00 2011-01-26
**/

public class Main 
{	
	public static void main(String[] args) 
	{
		parseToken token = new parseToken();
		token.readWriteXml();
	} // main method
} // main class
