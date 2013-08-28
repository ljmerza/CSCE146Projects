/*********************************************************************
 * Class to read an xml file and output it into a format that
 * seperates the tags and the data in a new file.
 *
 * @author Leonardo Merza
 * @version 1.00 2011-01-26
**/
import java.io.PrintWriter;
import java.util.Scanner;

public class parseToken 
{
	private PrintWriter outputStream = null;
	private Scanner inFile = null;
	private String currentRead;
	private int openTokens = 0;
	
/*********************************************************************
* Method to read an xml file and output the data to a zoutput file 
* in the proper format.
*
* **/
	public void readWriteXml()
	{
		this.openFiles();
		
		while( this.inFile.hasNext() )
		{
			if ( this.isToken() )
			{
				this.writeToken();
			} // if statement
			else
			{
				this.writeData();
			} // else if statement
		} // while loop
		
		this.outputStream.close();
		
		if( this.allTokensClosed() )
		{
			System.out.println("Xml file read and written correctly.");
		} // if statement
		else
		{
			System.out.println("Xml file not read and written correctly.");
		} // else statement
	} // readWriteXml method
	
/*********************************************************************
* Method to open and read files used in this program.
*
* **/
	private void openFiles()
	{
		outputStream = FileUtils.PrintWriterOpen("zoutput");
		inFile = FileUtils.ScannerOpen("zin");
	} // openFiles method
	
/*********************************************************************
* Method to see if next string is a token.
*
* @return boolean if string is a token or not.
* **/
	private boolean isToken()
	{
		boolean isToken = false;
		currentRead = inFile.next();
		if ( (currentRead.startsWith("<")) & (currentRead.endsWith(">")) )
		{
			isToken = true;
		} // if statement
		return isToken;
	} // isToken method

/*********************************************************************
* Method to output the token string into the zoutput file. First
* displays the entire token then displays the token with the tags.
*
* **/
	private void writeToken()
	{
		int lastIndex = currentRead.length();
		lastIndex = lastIndex - 1;
		
		if ( (currentRead.startsWith("<")) & (!(currentRead.startsWith("/", 1))) )
		{
			this.outputStream.println("token: '" + currentRead + "'");
			this.outputStream.println("open token: '" + currentRead.substring(1, lastIndex) + "'");
			openTokens++;
		} // if statement
		else
		{
			this.outputStream.println("token: '" + currentRead + "'");
			this.outputStream.println("close token: '" + currentRead.substring(0, lastIndex -1) + "'");
			openTokens--;
		} // else statement
	} // readToken method
	
/*********************************************************************
* Method to output the data string into the zoutput file
*
* **/
	private void writeData()
	{
		this.outputStream.println("token: '" + currentRead + "'");
		this.outputStream.println("just data: '" + currentRead + "'");
	} // writeData method
	
/*********************************************************************
* Method to verify if all tokens opened have been closed.
* 
*@return boolean if all tokens are closed or not.
* **/
	private boolean allTokensClosed()
	{
		boolean isTokensClosed = false;
		if(openTokens == 0)
		{
			isTokensClosed = true;
		} // if Statement
		return isTokensClosed;
	} // allTokensClosed
	
} // parseToken class
