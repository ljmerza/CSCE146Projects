import java.util.Scanner;
import java.io.PrintWriter;
/*********************************************************************
 * Driver class to read data into an array list and sort it by the 
 * candidate name.
 *
 * @author Leonardo Merza
 * @version 1.00 2011-02-02
**/
public class Driver
{

  public static void main (String[] args)
  {
	  Scanner inFile = null;
	  PrintWriter outFile = null;
	  
	  inFile = FileUtils.ScannerOpen("zunsorted.305");
	  outFile = FileUtils.PrintWriterOpen("zsorted.305");
	  
	  Insertsort sort = new Insertsort();
	  sort.readFile(inFile);
	  sort.sort();
	  sort.writeFile(outFile);
	  
	  FileUtils.closeFile(inFile);
	  FileUtils.closeFile(outFile);
  } // main method
  
} // Driver class
