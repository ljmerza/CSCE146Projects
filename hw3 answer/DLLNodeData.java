/*********************************************************************
 * Class for the data in a DLL node for Homework 3.
 *
 * The node data is a single entry to be pushed onto the stack or
 * else used to match up against data pushed on the stack.  We
 * choose to set three boolean variables for whether or not we have
 * an open tag, a close tag, or data.  (Since we have three options,
 * we cannot use a single boolean variable, so we use separate
 * variables.)  To facilitate testing, we store both the raw and
 * the parsed string data.
 *
 * There is actually nothing to this class except the accessors
 * and mutators, since we permit the invoking program to set the
 * various variables.  In a more sophisticated version we might have
 * all that done by a method in this class that parsed the input
 * raw string and set the variables.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-21
**/
public class DLLNodeData implements Comparable<DLLNodeData>
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private final String classLabel = "DLLNodeData: ";

  private boolean tokenClose;
  private boolean tokenData;
  private boolean tokenOpen; 
  private String sParsed;
  private String sRaw;

/*********************************************************************
 * Constructor.
**/
  public DLLNodeData()
  {
    this.tokenClose = false;
    this.tokenData  = false;
    this.tokenOpen  = false;
    this.sParsed = "";
    this.sRaw    = "";
  } // public DLLNodeData()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get <code>tokenClose</code>
 *
 * @return the value of <code>tokenClose</code>
**/
  public boolean getTokenClose()
  {
    return this.tokenClose;
  } // public boolean getTokenClose()

/*********************************************************************
 * Method to set <code>tokenClose</code>
 *
 * @param value value to assign
**/
  public void setTokenClose(boolean value)
  {
    this.tokenClose = value;
  } // public void setTokenClose(boolean value)

/*********************************************************************
 * Method to get <code>tokenData</code>
 *
 * @return the value of <code>tokenData</code>
**/
  public boolean getTokenData()
  {
    return this.tokenData;
  } // public boolean getTokenData()

/*********************************************************************
 * Method to set <code>tokenData</code>
 *
 * @param value value to assign
**/
  public void setTokenData(boolean value)
  {
    this.tokenData = value;
  } // public void setTokenData(boolean value)

/*********************************************************************
 * Method to get <code>tokenOpen</code>
 *
 * @return the value of <code>tokenOpen</code>
**/
  public boolean getTokenOpen()
  {
    return this.tokenOpen;
  } // public boolean getTokenOpen()

/*********************************************************************
 * Method to set <code>tokenOpen</code>
 *
 * @param value value to assign
**/
  public void setTokenOpen(boolean value)
  {
    this.tokenOpen = value;
  } // public void setTokenOpen(boolean value)

/*********************************************************************
 * Method to get <code>sParsed</code>
 *
 * @return the value of <code>sParsed</code>
**/
  public String getSParsed()
  {
    return this.sParsed;
  } // public String getSParsed()

/*********************************************************************
 * Method to set <code>sParsed</code>
 *
 * @param value value to assign
**/
  public void setSParsed(String value)
  {
    this.sParsed = value;
  } // public void setSParsed(String value)

/*********************************************************************
 * Method to get <code>sRaw</code>
 *
 * @return the value of <code>sRaw</code>
**/
  public String getSRaw()
  {
    return this.sRaw;
  } // public String getSRaw()

/*********************************************************************
 * Method to set <code>sRaw</code>
 *
 * @param value value to assign
**/
  public void setSRaw(String value)
  {
    this.sRaw = value;
  } // public void setSRaw(String value)

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to compare two entries.
 * This is just for show right now.
**/
  public int compareTo(DLLNodeData that)
  {
    int n = 0;
    return n;
  } // public String toString()

/*********************************************************************
 * Method to return a <code>String</code> version of the object.
**/
  public String toString()
  {
    String s = "";

    s += this.tokenOpen + " ";
    s += this.tokenClose + " ";
    s += this.tokenData + " ";
    s += String.format("'%s' '%s'",sRaw, sParsed);

    return s;
  } // public String toString()

} // public class DLLNodeData
