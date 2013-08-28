import java.util.ArrayList;
/*********************************************************************
 * Class to handle one domino.
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

  private boolean used; // if current domino is being used in list
  private boolean drawn; // if current domino is drawn into a hand or not
  private ArrayList<Integer> dotcount;  // the dots on each side of domino

/*********************************************************************
 * Constructor.
**/
  public OneDomino(int aDots, int bDots)
  {
    this.setDrawn(false);
    this.dotcount = new ArrayList<Integer>();
    this.dotcount.add(aDots);
    this.dotcount.add(bDots);
  } // public OneDomino()

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
    return this.dotcount.get(which);
  } // public int getDotcount(int which)

/*********************************************************************
 * Accessor for the <code>drawn</code>.
 *
 * @return the value of <code>drawn</code>.
**/
  public boolean isDrawn()
  {
    return this.drawn;
  } // public boolean isDrawn()

/*********************************************************************
 * Mutator for the <code>drawn</code>.
 *
 * @param the value of <code>drawn</code> to be set.
**/
  public void setDrawn(boolean what)
  {
    this.drawn = what;
  } // public void setDrawn(boolean what)

  /*********************************************************************
   * Accessor for the <code>used</code>.
   *
   * @return the value of <code>used</code>.
  **/
   public boolean isUsed()
   {
  	 return this.used;
   } // public boolean isUsed()

/*********************************************************************
 * Mutator for the <code>used</code>.
 *
 * @param the value of <code>used</code> to be set.
**/
   public void setUsed(boolean what)
   {
  	 this.used = what;
   } // public void setUsed(boolean what)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to flip the sides of the current domino.
 *
**/
  public void flipSides()
  {
  	int sideOne;
  	int sideTwo;
  	sideOne = this.dotcount.get(0);
  	sideTwo = this.dotcount.get(1);
  	
  	this.dotcount.clear();
  	this.dotcount.add(sideTwo);
  	this.dotcount.add(sideOne);
  } // public void flipSides()
  
/*********************************************************************
 * Method that says Y or N if a domino is used or not
 *
 *@return the <code>String</code> value Y or N if the domino is used
**/
  private String DominoUsedString()
  {
  	String theString = null;
  	if(this.isUsed() == true)
  	{
  		theString = "Y";
  	} // if statement
  	else
  	{
  		theString = "N";
  	} // else statement
  	return theString;
  } // public DominoUsedString()
  
/*********************************************************************
 * Method to convert a domino to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the domino.
**/
  public String toString()
  {
    String s;
    s = String.format("(%2s %3d %3d)", this.DominoUsedString(), this.getDotcount(Constants.SIDEA), this.getDotcount(Constants.SIDEB));
    return s;
  } // public String toString()

} // public class OneDomino
