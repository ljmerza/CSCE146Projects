/*********************************************************************
 * Interface for the intermediate class for the dominoes game.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-14
**/
public interface IDominoGame
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private ArrayList<OneDomino> theList;
//  private ArrayList<OneDomino> theHand;

/*********************************************************************
 * Method to create a hand.
**/
  public void createHand();

/*********************************************************************
 * Method to display a hand.
**/
  public void displayHand();

/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the standard return from a <code>toString</code>.
**/
  public String toString();

} // public interface IDominoGame
