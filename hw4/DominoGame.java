import java.util.ArrayList;
/*********************************************************************
 * Intermediate class for running the dominoes game. This class 
 * creates a domino list and then creates a hand from that list. From 
 * that hand, it can be given an <code>Integer</code> value, and will
 * find the longest chain that the hand can create starting from
 * that integer.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-14
**/
public class DominoGame implements IDominoGame
{
/*********************************************************************
 * Instance variables for the class.
**/
	private int longestChain; // current longest chain that's being worked on
	private int theLongestChain; // the longest chain found so far
  private int recursionLevel; // what level of recursion the method is at
  private int dominoSubscript; // the subscript of the current domino being compared
	private int previousDominoNumber; // keeps track of the previous number being compared to
  private boolean isMatched; // if there is a match of numbers in the current domino comparison
  private boolean isLongestFound; // is the longest chain of dominoes currently found
  
  private ArrayList<Integer> dominoSubscripts; // stores the subscript of theHand of each domino in the list
  private ArrayList<OneDomino> theList; // the full list of the 91 dominoes
  private ArrayList<OneDomino> theHand; // the current hand of 12 dominoes
	private DominoList dominoList = null; // list of matching dominoes

/*********************************************************************
 * Constructor.
**/
  public DominoGame()
  {
    this.theHand = new ArrayList<OneDomino>();
    this.dominoList = new DominoList();
    this.theList = new ArrayList<OneDomino>();
    this.dominoSubscripts = new ArrayList<Integer>();

    this.longestChain = 0;
    this.theLongestChain = 0;
    this.recursionLevel = 0;
    this.isLongestFound = false;
    
    this.createList();
  } // public DominoGame()

/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/
/*********************************************************************
 * Method to return a OneDomino object from the current list of
 * matching dominoes
 *
 * @param the subscript of the domino to return
**/
  public OneDomino getDomino(int which)
  {
    return this.theList.get(which);
  } // public OneDomino getDomino(int which)

/*********************************************************************
 * Method to return the size of the current hand.
**/
  public int handSize()
  {
    return this.theHand.size();
  } // public int handSize()

/*********************************************************************
 * Method to return the size of the list of matching dominoes
**/
  public int listSize()
  {
    return this.theList.size();
  } // public int listSize()

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to create a hand of 12 dominoes
**/
  public void createHand()
  {
    int numberDrawn = 0;
    while( numberDrawn < Constants.HANDSIZE )
    {
      int sub = (int) (Math.random() * this.theList.size());
      if( !this.theList.get(sub).isDrawn() )
      {
        this.theHand.add(this.theList.get(sub));
        this.theList.get(sub).setDrawn(true);
        ++numberDrawn;
      } // if domino is not drawn then add to hand
    } // while the number of dominoes drawn is less than 12
  } // public void createHand()

/*********************************************************************
 * Method to create the entire list of 91 dominoes.
 *
**/
  private void createList()
  {
    for(int i = 0; i <= Constants.LARGESTDOTCOUNT; ++i) // note zero THROUGH N
    {
      for(int j = 0; j <= i; ++j) // note zero THROUGH i
      {
        OneDomino dom = new OneDomino(i, j);
        this.theList.add(dom);
      } // for loop that creates a new domino object and adds to list
    } // for loop that creates numbers for the new domino object
  } // private void createList()

/*********************************************************************
 * Method to display a hand.  This displays each domino in a hand by
 * showing if the domino is currently used then showing the number
 * of each side of the domino
**/
  public void displayHand()
  {
    String s = "X";

    for(OneDomino domino: theHand)
    {
      s += domino.toString();
    } // for each loop that adds to a string each domino
    s += "X\n";
    FileUtils.logFile.printf("%s%n", s);

  } // public void displayHand()

/*********************************************************************
 * Method to get the longest chain in the hand starting from the given
 * integer in the arguments.
 * 
 * @param the <code>Integer</code> value that will be used to start the
 * search for a matching domino in a hand
 * 
 * @return the longest chain of dominoes that can be created starting
 * from the given <code>Integer</code>
**/
  public int getLongestChain(int start)
  {
  	if( isLongestFound )
  	{
  		this.resetGame();
  	} // if previous longest chain has been found then reset all variables
  	
  	if( recursionLevel == 0 )
  	{
  		FileUtils.logFile.printf("extendCurrent " + recursionLevel + ": XX\n");
  		FileUtils.logFile.printf("extendHand " + recursionLevel + ": ");
  		this.displayHand();
  		recursionLevel++;
  	} // if starting a new comparison list then print initial information

  	this.matchDominoes(start);
  	if( dominoSubscript != Constants.HANDSIZE )
  	{
  		longestChain++;
    	dominoSubscript = 0;
  		this.getLongestChain(dominoList.getLast().getDotcount(Constants.SIDEB));
  	} // if domino subscript is less than hand size then reset subscript number and recall method to find new match
  	else if( (dominoList.size()) > 1 && (dominoSubscripts.lastIndexOf(this.dominoSubscripts) < Constants.HANDSIZE - 1) )
  	{
  		this.logInfo(start, -1);
  		this.getLongestChain(dominoList.getLast().getDotcount(Constants.SIDEB));
  	} // else if domino list size is at least one and the subscript of the last domino is less than the hand
  	 // delete last domino in the list and use previous domino in the recursion to find a new match
  	
  	isLongestFound = true;
  	return theLongestChain;
  } // public int getLongestChain(int start)
  
/*********************************************************************
 * Method to compare dominoes in a hand from a list of dominoes to
 * see if they match and if they do then put them together
 * 
 * @param the <code>Integer</code> value that will be used to start the
 * search for a matching domino in a hand
**/
  private void matchDominoes(int start)
  {
  	isMatched = false;

  	while( !(isMatched) && (dominoSubscript <= (Constants.HANDSIZE - 1)) )
  	{
  		if( !(this.theHand.get(dominoSubscript).isUsed()) )
  		{	
  			this.logInfo(start, 0);
  		
  			if( this.theHand.get(dominoSubscript).getDotcount(Constants.SIDEA) == start )
  			{
  				isMatched = true;
  			} // if current domino in hand matches sideA then return found
  			else if( this.theHand.get(dominoSubscript).getDotcount(Constants.SIDEB) == start )
  			{
  				this.theHand.get(dominoSubscript).flipSides();
  				isMatched = true;
  			} // else if current domino in hand matches sideB then return found
  		
  			if(isMatched)
  			{
  				dominoList.add(this.theHand.get(dominoSubscript));
  				this.theHand.get(dominoSubscript).setUsed(true);
  				this.logInfo(start, 1);
  			} // if there is a match of dominoes then add to list and set used
  		} // if current domino being used to compare is not in use already
  		
  		dominoSubscript++;
  	} // while there is no match or current domino is less than the hand size search for match
  	
  } // public void matchDominoes()

/*********************************************************************
* Method to display log information. This method will display the
* current longest chain. It will also show the reverse recursion
* and will call a method to delete the last domino.  Lastly, it
* can add a domino to the list and add the subscript of that domino 
* to the arralist storage.
* 
* @param the integer that is being looked for in matching dominoes
* 
* @param integer -1 if displaying backing up info, 0 if displaying 
* general info, and 1 if displaying adding info
**/
  private void logInfo(int start, int display)
  {
  	if( display == -1 )
  	{
  		if(theLongestChain < longestChain)
  		{
  			theLongestChain = longestChain;
  			
  			FileUtils.logFile.printf("%14s %d: ", "DONENEWLONGEST", recursionLevel);
  			dominoList.displayList();
  			FileUtils.logFile.printf("%14s %d: ", "DONEhand      ", recursionLevel);
  			this.displayHand();
   		} // if the current longest chain found is longer than the longest chain ever found then replace
  		
  		this.goBack();
  		FileUtils.logFile.printf("%12s %d: %2d (%d) ", "BACKFROMhand", recursionLevel, dominoSubscript, previousDominoNumber);
  		this.displayHand();
  	} // if display equals -1, called if dominoscript is equal to hand size
  	else if( display == 0 )
  	{
  		FileUtils.logFile.printf("%8s %d: %2d (%d) ", "TESTcurr", recursionLevel, dominoSubscript, start);
  		dominoList.displayList();
  		
  		FileUtils.logFile.printf("%8s %d: %2d (%d) %s\n", "TESTdom ", recursionLevel, dominoSubscript, start, 
  											this.theHand.get(dominoSubscript).toString());

  		FileUtils.logFile.printf("%8s %d: %2d (%d) ", "TESTcurr", recursionLevel, dominoSubscript, start);
  		this.displayHand();
  	} // else if display equals 0, will display testing domino information
  	else if( display == 1 )
  	{
  		FileUtils.logFile.printf("%11s %d: %2d (%d) ", "ADDEDTOhand", recursionLevel, dominoSubscript, start);
    		this.displayHand();
    		this.dominoSubscripts.add(dominoSubscript);
    		previousDominoNumber = start;
    		
    		FileUtils.logFile.printf("extendCurrent " + recursionLevel + ": " + dominoList.toString()+ "\n");
    		FileUtils.logFile.printf("extendHand " + recursionLevel + ": ");
    		this.displayHand();
    		recursionLevel++;
  	} // else if display equals 1, add domino subscript to array and set searched number to sideB of new domino
		
  } // private void logInfo()
  
/*********************************************************************
 * Method that will go back a recursion level and get rid of the last
 * domino in a list of dominoes that match up in order to search for
 * other matches for the longest chain.  This method will also find
 * the subscript for the domino being deleted so it can start from the
 * next domino in the hand instead of starting all over.
**/
  private void goBack()
  {
  	boolean isFound = false;
  	recursionLevel--;
		longestChain--;
		dominoSubscript = ( dominoSubscripts.remove(dominoSubscripts.size() - 1) + 1 );
		for(int i = 0; !(isFound); i++)
		{
			if( dominoList.getLast().toString().equals(this.theHand.get(i).toString()) )
			{
				this.theHand.get(i).setUsed(false);
				isFound = true;
			} // if last domino in list equals a domino in hand then set that to domino's used to false
		} // for loop until the matching domino to delete is found
		dominoList.deleteLast();
		
  } // public void goBack()
  
/*********************************************************************
 * Method to reset all variables that are used in this object 
 * in order to reuse them again. Also resets all domino's used
 * variables to false.
**/
    private void resetGame()
    {
    	longestChain = 0;
    	theLongestChain = 0;
      recursionLevel = 0;
      dominoSubscript = 0;
      previousDominoNumber = 0;
      isMatched = false;
      isLongestFound = false;
      
      this.dominoSubscripts.clear();
      this.theList.clear();
      
      for(int i = 0; i < this.theHand.size(); i++)
      {
      	this.theHand.get(i).setUsed(false);
      } // for loop that sets all domino's used variable to false
      
    } // public void resetGame()
    
/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the standard return from a <code>toString</code>.
**/
  public String toString()
  {
    String s = "X";

    for(OneDomino domino: theList)
    {
      s += domino.toString();
    } // for each loop that goes through list and adds to a string
    
    s += "X\nXX\n";
    return s;
  } // public String toString()

} // public class DominoGame
