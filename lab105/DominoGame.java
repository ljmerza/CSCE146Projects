import java.util.ArrayList;
import java.util.Random;
/*********************************************************************
 * Class for the intermediate class for the dominoes game.
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
private ArrayList<OneDomino> theList;
private ArrayList<OneDomino> theHand;
private OneDomino[] aDomino = null;
private Random randomizer = null;

/*********************************************************************
 * Method to create a hand.
**/
  public void createHand()
  {	 	
	 int pickDomino;
	randomizer = new Random();
	aDomino = new OneDomino[92];
  	theHand = new ArrayList<OneDomino>(12);
  	theList = new ArrayList<OneDomino>(91);
  	
  	int dominoNumber = 0;
  	for(int j = 0; j <= 12; j++)
  	{
  		for(int k = 0; k <= j; k++)
  		{
  	  		aDomino[dominoNumber++] = new OneDomino(j, k);
  	  		theList.add(aDomino[dominoNumber -1]);
  		} // for loop creating second number
  			

  	} // for loop creating first number
  	
  	for(int h = 0; h < theList.size(); h++)
  	{
  		System.out.println(theList.get(h));
  	}

  	
  	for(int i = 0; theHand.size() < 12; i++)
  	{
  		pickDomino = randomizer.nextInt(91);
  		theHand.add(aDomino[pickDomino]);
  		aDomino[i].setDrawn(true);
  	}
  } // public void createHand()

/*********************************************************************
 * Method to display a hand.
**/
  public void displayHand()
  {
  	for(int i = 0; i < theHand.size(); i++)
  	{
  		System.out.println(theHand.get(i));
  	} // for loop
  } // public void displayHand()

/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the standard return from a <code>toString</code>.
**/
  public String toString()
  {
  	String theString = "";
  	for(int i = 0; i < 91; i++)
  	{
  	  	theString += theList.get(i).toString();
  	}
  	return theString;
  } // public String toString()
  

public ArrayList<OneDomino> getTheList() {
	return theList;
}

public void setTheList(ArrayList<OneDomino> theList) {
	this.theList = theList;
}

public ArrayList<OneDomino> getTheHand() {
	return theHand;
}

public void setTheHand(ArrayList<OneDomino> theHand) {
	this.theHand = theHand;
}

} // public class IDominoGame
