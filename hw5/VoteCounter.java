import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * This class will read a file full of voter data and count the votes
 * by using a TreeMap to store the contest and candidate information
 * in a string and the count of votes in an integer.  Once the file
 * has been read, it will then create a string with the data in a 
 * ordered format and display the total votes for each candidate
 * by order of contest. This class will also display the number of
 * new votes it has come across while reading the file.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-03-03
**/
public class VoteCounter
{
/*********************************************************************
 * Instance variables for the class.
**/
  private TreeMap<String, Integer> theList; // the TreeMap used to count votes
  private int ballotsCast; 									// to keep track of new votes
  private String contestString = ""; 				// separate the contest string
  private String candidateString = "";		  // separate the candidate string

/*********************************************************************
 * Constructor.
**/
  public VoteCounter()
  {
    this.theList = new TreeMap<String, Integer>();
    ballotsCast = 0;
  } // public VoteCounter()

/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/
/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method that reads from a vote data file and adds data to a
 * TreeMap and increments the value each time it finds a vote
 * that matches an already existing TreeMap key. If it does
 * not find a matching key, then it creates a new key and starts the
 * new value at one.
 *
 * After reading in all the data, it turns the TreeMap keys into
 * strings and writes each key and its total value.
 *
 * @param inFile the <code>Scanner</code> from which to read data.
 * @param outFile the <code>PrintWriter</code> to which to write.
**/
  public void doTheWork(Scanner inFile, PrintWriter outFile)
  { 
  	int numberOfVotes; //used to copy the current value of a key and increment
		String s; // used to grab the contest and candidate for comparison
  	OneLine line = new OneLine(); // used to temporarily store a condidate's data

    while(inFile.hasNext())
    {
    	s = "";
    	line = line.readLine(inFile);
    	
    	if(line.isNewBallot())
    	{
    		++ballotsCast;
    	} // if new ballot then add one to ballotsCast int
    	
    	s += line.getContest() + "##"+ line.getCandidate();
    	
      if( this.theList.containsKey(s) ) 
      {
      	numberOfVotes = theList.get(s);
      	this.theList.put(s, numberOfVotes + 1);
      } // if the TreeMap contains the current contest and candidate string
      else
      {
      	this.theList.put(s, 1);
      } // else create a new TreeMap value with the new string
    } // while the input file hasNext()
    
    outFile.printf("A total of %4d ballots were cast.%n", ballotsCast);
    outFile.printf(this.toString());
   	
  } // public void doTheWork(Scanner inFile, PrintWriter outFile)

/*********************************************************************
 * Standard <code>toString</code> method that will convert a TreeMap 
 * into an array in alphabetical order and run a for each loop to 
 * add data in correct format into a single <code>string</code> 
 * to return.
 * 
 * @return the <code>string</code> version of the TreeMap
**/
  public String toString()
  {	
  	int index = 0;
  	String theString = "";
  	ArrayList<String> keys = new ArrayList<String>(theList.keySet());
   
  	for (String key : keys)
  	{
  		index = key.indexOf("##");
  		contestString = key.substring(0 , index);
  		candidateString = key.substring(index + 2);
  		theString += String.format("%39s %37s %4d%n", contestString, candidateString, theList.get(key));
  	} // for each loop that separates the string key and adds it to the string in correct format
   
  	return theString;
  } // public String toString()

} // public class VoteCounter
