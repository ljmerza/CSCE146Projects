import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Class to read a file, sort that file, and write it to a new file.
 *
 * @author Leonardo Merza
 * @version 1.00 2011-02-02
**/

public class Insertsort
{
/*********************************************************************
	* Instance variables for the class.
**/
	private ArrayList<OneLine> list = new ArrayList<OneLine>();

/*********************************************************************
 * General methods
**/
/*********************************************************************
	*Method to read a file and add each line into an array list
	*
	*@param the Scanner file that will be read from
**/
	public void readFile(Scanner inFile)
	{
		OneLine oneLine = new OneLine();
		oneLine = oneLine.readOneLine(inFile);

		while (oneLine.getCandidate() != "dummy")
		{
				list.add(oneLine);
				oneLine = oneLine.readOneLine(inFile);
		} // while loop
		
	} // public void readFile(Scanner inFile)

	/*********************************************************************
	 * Method to do a complete insertionsort on the <code>ArrayList</code>.
	**/
	  public void sort()
	  {
	    for(int i = 1; i < this.list.size(); ++i)
	    {
		    for(int j = i; j >= 1; --j)
		    {
		      if(this.list.get(j).compareTo(this.list.get(j-1)) < 0)
		      {
		        OneLine temp = new OneLine();
		        temp = this.list.get(j);
		        this.list.set(j, this.list.get(j-1));
		        this.list.set(j-1, temp);
		      } // if statement
		    } // inner for loop
	    } // outer for loop
	  } // private void insertionSort()


/*********************************************************************
*Method to write a sorted array list to a file
**/
	public void writeFile(PrintWriter output)
	{
		for( int i = 0; i < list.size(); ++i )
		{
			output.print(list.get(i).toString());
		} // for loop
		
	} // public void writeFile(PrintWriter output)

} // public class Insertsort