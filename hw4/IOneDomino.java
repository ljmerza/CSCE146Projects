import java.util.ArrayList;
/*********************************************************************
 * Interface for the <code>OneDomino</code> class.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-14
**/
public interface IOneDomino
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private boolean drawn;
//  private boolean used;
//  private ArrayList<Integer> dots;  // the dots on each side

/*********************************************************************
 * Constructor.
**/
//  public OneDomino(int aDots, int bDots);

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Accessor for the <code>dots</code>.
 *
 * @return the value of <code>dots</code>.
**/
  public int getDotcount(int which);

/*********************************************************************
 * Accessor for the <code>drawn</code>.
 *
 * @return the value of <code>drawn</code>.
**/
  public boolean isDrawn();

/*********************************************************************
 * Accessor for the <code>used</code>.
 *
 * @return the value of <code>used</code>.
**/
  public boolean isUsed();

/*********************************************************************
 * Mutator for the <code>drawn</code>.
 *
 * @param the value of <code>drawn</code> to be set.
**/
  public void setDrawn(boolean what);

/*********************************************************************
 * Mutator for the <code>used</code>.
 *
 * @param the value of <code>used</code> to be set.
**/
  public void setUsed(boolean what);

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to convert a domino to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the domino.
**/
  public String toString();

} // public interface IOneDomino
