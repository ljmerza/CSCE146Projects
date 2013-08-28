import java.util.ArrayList;

/*********************************************************************
 * Class for handling one list of dominoes.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-15
**/
public class DominoList implements IDominoList
{
/*********************************************************************
 * Instance variables for the class.
**/
	private ArrayList<OneDomino> theList;

/*********************************************************************
 * Constructor.
 *
**/
	public DominoList()
	{
	  this.theList = new ArrayList<OneDomino>();
	} // public DominoList()
	
/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/
/*********************************************************************
 * Method to return one domino.
 *
 * @param which the subscript of the domino to return
**/
  public OneDomino get(int which)
  {
  	return this.theList.get(which);
  } // public OneDomino get(int which)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a domino to the list.
 *
 * @param what the domino to be added
**/
  public void add(OneDomino what)
  {
  	this.theList.add(what);
  } // public void add(OneDomino what)
  
/*********************************************************************
 * Method to get the last domino in the list
 *
 * @return the last domino in the list
**/
	public OneDomino getLast()
	{
			return this.theList.get(theList.size() - 1);
	} // public void add(OneDomino what)

/*********************************************************************
 * Method to delete the last item in a list.
**/
  public void deleteLast()
  {
  	this.theList.remove(this.size() - 1);
  } // public void deleteLast()

/*********************************************************************
 * Method to return the size of this list.
 *
 * @return the size
**/
  public int size()
  {
  	return this.theList.size();
  } // public int size()

/*********************************************************************
 * Method to display the list of dominoes.
**/
  public void displayList()
  {
    String s = "X";

    for(OneDomino domino: theList)
    {
      s += domino.toString();
    } // for each loop that adds each domino to a string in string format
    s += "X";
    FileUtils.logFile.printf("%s%n", s);

  } // public void displayList()
  
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
    } // for each loop that adds each domino to a string in string format
    
    s += "X";
    return s;
  } // public String toString()
} // public class DominoList implements IDominoList
