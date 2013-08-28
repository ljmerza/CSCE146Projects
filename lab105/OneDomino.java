import java.util.ArrayList;
/*********************************************************************
 * Class for the <code>OneDomino</code> class.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-14
**/
public class OneDomino implements IOneDomino
{
/*********************************************************************
 * Instance variables for the class.
**/
private boolean drawn;
private ArrayList<Integer> dots;  // the dots on each side

/*********************************************************************
 * Constructor.
**/
public OneDomino(int aDots, int bDots)
{
	dots = new ArrayList<Integer>(2);
	dots.add(aDots);
	dots.add(bDots);
	drawn = false;
} // public OneDomino(int aDots, int bDots)

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Accessor for the <code>dots</code>.
 *
 * @return the value of <code>dots</code>.
**/
  public int getDotcount(int which)
  {
  	int returningDot;
  	if(which == 1)
  	{
  		returningDot = dots.get(0);
  	} // if statement
  	else
  	{
  		returningDot = dots.get(1);
  	} // else statement
  	return returningDot;
  } // public int getDotcount(int which)

/*********************************************************************
 * Accessor for the <code>drawn</code>.
 *
 * @return the value of <code>drawn</code>.
**/
  public boolean isDrawn()
  {
  	return drawn;
  } // public boolean isDrawn()

/*********************************************************************
 * Mutator for the <code>drawn</code>.
 *
 * @param the value of <code>drawn</code> to be set.
**/
  public void setDrawn(boolean what)
  {
  	drawn = what;
  } // public void setDrawn(boolean what)

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to convert a domino to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the domino.
**/
  public String toString()
  {
  	String theString;
  	theString = "This domino's sides are " + this.getDotcount(1) + " and " + this.getDotcount(2);
  	return theString;
  } // public String toString()

} // public class IOneDomino
