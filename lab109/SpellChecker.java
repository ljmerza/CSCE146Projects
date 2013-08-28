import java.util.HashSet;
import java.util.Scanner;
/*********************************************************************
 * 
 *
 * @author Leonardo Merza
 * @version 1.00 2011-03-16
**/
public class SpellChecker
{
	HashSet<String> hashSet = null;
/*********************************************************************
 * Instance variables for this class.
**/
	private final String spell = "SpellChecker:  ";
/*********************************************************************
 * Constructor.
**/
	public SpellChecker()
	{
		this.hashSet = new HashSet<String>();
	} // public SpellChecker()
	
/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
	
/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * This method will read a file of words and check to see if they are
 * in the dictionary file provided.  This method will strip away
 * commas and periods and convert all letters to lower case in order
 * to make these comparisons.
 * 
 * @param the file that will be used to read the words from
 * 
**/
	public void checkSpelling(Scanner inFile)
	{
		String theString;
		
		while(inFile.hasNext())
		{
			theString = inFile.next();	
			theString = theString.toLowerCase();
			theString = theString.replace(",", "");
			theString = theString.replace(".", "");
			
			if(hashSet.contains(theString))
			{
				FileUtils.logFile.println(spell + "'" + 
						theString + "' is in the dictionary");
			} // if the hashset contains the word in the string
			else
			{
				FileUtils.logFile.println(spell + "'" + 
						theString + "' is NOT in the dictionary");	
			} // else if the word is not in the hashset
			
		} // while the file has a next value to read

	} // public checkSpelling(Scanner inFile)
	
/*********************************************************************
 * This method will read a dictionary file and read each value into
 * a HashSet in order to use that HashSet in a spell checker method.
 * 
 * @param the dictionary file that well be used to get the words from
**/
	public void buildDictionary(Scanner inFile)
	{
		String theString;
		
		while(inFile.hasNext())
		{
			theString = inFile.next();	
			this.hashSet.add(theString);
		} // while the file has a next value, add to HashSet
		
	} // public void buildDictionary(Scanner inFile)	  
	
} // public class SpellChecker

