// YOUR CODE MUST INCLUDE A CLASS THAT IMPLEMENTS THIS INTERFACE
/*********************************************************************
 * Interface for managing <code>key</code> data.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-07
**/
public class Key implements IKey
{
	private String theKey;
/*********************************************************************
 * Constructor.
**/
	Key(ProcessInfo proc)
	{
		this.theKey = proc.getPid() + " " + proc.getName();
	} // public ProcessInfo()
/*********************************************************************
 * Standard <code>compareTo</code> method.
 *
 * @return -1, 0, or +1 as appropriate
**/
  public int compareTo(Key that)
  {
	  int returnValue;

	  returnValue = 0;

	  if(this.theKey.substring(1).compareTo(that.theKey.substring(1)) < 0)
	  {
	     returnValue = -1;
	  } // if statement
	  else if(this.theKey.substring(1).compareTo(that.theKey.substring(1)) > 0)
	  {
	    returnValue = +1;
	  } // else if statement
	  else
	  {
	    returnValue = 0;
	  } // else statement

	  return returnValue;
  } // compareTo method

/*********************************************************************
 * Standard <code>toString</code>.
 *
 * @return the <code>String</code> value of <code>key</code>.
**/
  public String toString()
  {
	  String theString;
	  theString = this.toString();
	  return theString;
  } // toString method

} // public interface IKey
