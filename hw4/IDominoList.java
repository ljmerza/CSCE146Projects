/*********************************************************************
 * Interface defining the class for handling one list of dominoes.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-15
**/
public interface IDominoList
{
/*********************************************************************
 * Accessors and mutators.
 * None needed; the only methods are general processing methods.
**/
/*********************************************************************
 * Method to return one domino.
 *
 * @param which the subscript of the domino to return
**/
  public OneDomino get(int which);

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a domino to the list.
 *
 * @param what the domino to be added
**/
  public void add(OneDomino what);

/*********************************************************************
 * Method to delete the last item in a list.
**/
  public void deleteLast();

/*********************************************************************
 * Method to return the size of this list.
 *
 * @return the size
**/
  public int size();

/*********************************************************************
 * Standard <code>toString</code> method.
 *
 * @return the standard return from a <code>toString</code>.
**/
  public String toString();
}
