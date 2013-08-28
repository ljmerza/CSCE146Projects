import java.util.ArrayList;
/*********************************************************************
 * Class to handle one domino.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-14
**/
public class OneDomino implements IOneDomino
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private final String TAG = "OneLine: "; // for debugging

  private static final int SIDEA = 0;
  private static final int SIDEB = 1;

  private boolean drawn;
  private ArrayList<Integer> dotcount;  // the dots on each side

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
 * General methods.
**/
/*********************************************************************
 * Standard comparison method.
 * This compares the <code>candidate</code> instance variables.
 *
 * @return -1, 0, or 1 according as the comparison goes.
  public int compareTo(OneLine that)
  {
    return this.getCandidate().compareTo(that.getCandidate());
  } // public int compareTo(OneLine that)
**/

/*********************************************************************
 * Method to convert a domino to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the domino.
**/
  public String toString()
  {
    String s;
    s = String.format("(%3d %3d)", this.getDotcount(SIDEA), this.getDotcount(SIDEB));
    return s;
  } // public String toString()

} // public class OneDomino
