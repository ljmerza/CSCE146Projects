import java.util.ArrayList;
/*********************************************************************
 * Intermediate class for running the dominoes game.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-14
**/
public class DominoGame implements IDominoGame
{
/*********************************************************************
 * Instance variables for the class.
**/
  private final String TAG = "DominoGame: ";

  private final int HANDSIZE = 12;
  private final int LARGESTDOTCOUNT = 12;
  private final int SIDEA = 0;
  private final int SIDEB = 1;

  private ArrayList<OneDomino> theList;
  private ArrayList<OneDomino> theHand;

/*********************************************************************
 * Constructor.
 *
 * Note that the constructor has to create the list of dominoes.
**/
  public DominoGame()
  {
    this.theList = new ArrayList<OneDomino>();
    this.theHand = new ArrayList<OneDomino>();
    this.createList();
  }

/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/
/*********************************************************************
 * Method to return the size of the hand for testing purposes.
 *
 * @param which the subscript of the domino to return
**/
  public OneDomino getDomino(int which)
  {
    return this.theList.get(which);
  } // public OneDomino getDomino(int which)

/*********************************************************************
 * Method to return the size of the hand for testing purposes.
**/
  public int handSize()
  {
    return this.theHand.size();
  } // public int handSize()

/*********************************************************************
 * Method to return the size of the list for testing purposes.
**/
  public int listSize()
  {
    return this.theList.size();
  } // public int listSize()

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to create a hand.
**/
  public void createHand()
  {
    int numberDrawn = 0;
    while(numberDrawn < HANDSIZE)
    {
      int sub = (int) (Math.random() * this.theList.size());
      if(!this.theList.get(sub).isDrawn())
      {
        this.theHand.add(this.theList.get(sub));
        this.theList.get(sub).setDrawn(true);
        ++numberDrawn;
      }
    }
  } // public void createHand()

/*********************************************************************
 * Method to create the entire list of dominoes.
 *
 * We will hard code these loops as double-12.
**/
  private void createList()
  {
    for(int i = 0; i <= LARGESTDOTCOUNT; ++i) // note zero THROUGH N
    {
      for(int j = 0; j <= i; ++j) // note zero THROUGH i
      {
        OneDomino dom = new OneDomino(i, j);
        this.theList.add(dom);
      }
    }
  } // private void createList()

/*********************************************************************
 * Method to display a hand.
**/
  public void displayHand()
  {
    String s = "";

    for(OneDomino domino: theHand)
    {
      s += domino.toString();
    }

    System.out.printf("%s %s%n", TAG, s);

  } // public void displayHand()

/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the standard return from a <code>toString</code>.
**/
  public String toString()
  {
    String s = "";

    for(OneDomino domino: theList)
    {
      s += domino.toString();
      if(domino.getDotcount(SIDEA) == domino.getDotcount(SIDEB))
        s += "\n";
    }

    return s;
  } // public String toString()

} // public class DominoGame
