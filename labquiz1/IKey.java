// YOUR CODE MUST INCLUDE A CLASS THAT IMPLEMENTS THIS INTERFACE
/*********************************************************************
 * Interface for managing <code>key</code> data.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-07
**/
public interface IKey
{

/*********************************************************************
 * Standard <code>compareTo</code> method.
 *
 * @return -1, 0, or +1 as appropriate
**/
  public int compareTo(Key that);

/*********************************************************************
 * Standard <code>toString</code>.
 *
 * @return the <code>String</code> value of <code>key</code>.
**/
  public String toString();

} // public interface IKey
