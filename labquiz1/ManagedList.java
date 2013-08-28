import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Class for managing a list of data items.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-07
**/
public class ManagedList
{
/*********************************************************************
 * Instance variables.
**/
  static final String classLabel = "MList: "; // for testing

  private ArrayList<ProcessInfo> theProcs; /** the data items */

/*********************************************************************
 * Default constructor.
**/
  public ManagedList()
  {
    this.theProcs = new ArrayList<ProcessInfo>();
  } // public ManagedList()

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to read the file from an input <code>Scanner</code> file.
 *
 * We do not bulletproof this code.  It will fail if the data input
 * does not match what we expect to read.  But this is a lab quiz
 * and therefore we will keep this as simple as possible.
 *
 * @param inFile the <code>Scanner</code> from which to read.
 *
 * @return the <code>ManagedList</code> that was read.
**/
  public ManagedList readFile(Scanner inFile)
  {
    int howMany;
    ProcessInfo localProc = null;

    howMany = inFile.nextInt();
    for(int sub = 0; sub < howMany; ++sub)
    {
      localProc = new ProcessInfo();
      localProc.readInfo(inFile);
      this.theProcs.add(localProc);
    }

    return this;
  } // public ManagedList readFile(Scanner inFile)

/*********************************************************************
 * Method to sort the list with an insertion sort.
**/
  public void sortTheList()
  {

	    for(int i = 1; i < this.theProcs.size(); ++i)
	    {
	        for(int j = i; j >= 1; --j)
	        {
	          if(this.theProcs.get(j).compareTo(this.theProcs.get(j-1)) < 0)
	          {
	        	ProcessInfo temp = new ProcessInfo();
	            temp = this.theProcs.get(j);
	            this.theProcs.set(j, this.theProcs.get(j-1));
	            this.theProcs.set(j-1, temp);
	          }
	        }
	    }

  } // public void sortTheList()

/*********************************************************************
 * Method to convert an entire <code>FlatFile</code> to a
 * <code>String</code>.  Note that there is no newline at the end of
 * the string.
 *
 * @return the <code>String</code> value of the <code>FlatFile</code>.
**/
  public String toString()
  {
    String s = "";

    for(ProcessInfo proc: this.theProcs)
    {
      s += proc.toString() + "\n";
    }

    return s;
  } // public String toString()

} // public class ManagedList
