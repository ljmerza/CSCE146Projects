import java.util.Scanner;
/*********************************************************************
 * Driver for HW 2 on doubly linked lists.
 *
 * @author Duncan A. Buell Modifications by Leonardo Merza
 * @version 1.00 2011-01-11
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    Scanner inFile = null;
    OneLine oneLine = null;
    VoteSummary voteSummary = null;

    inFile = FileUtils.ScannerOpen("zunsorted.305");
    FileUtils.setLogFile("zsorted.305");

    voteSummary = new VoteSummary();
    FileUtils.logFile.flush();

    while( inFile.hasNext() )
    {
    	oneLine = OneLine.readOneLine(inFile);
      voteSummary.add(oneLine);
      FileUtils.logFile.flush();
    } // while(inFile.hasNext())
  
    FileUtils.logFile.printf("%s", voteSummary.toString());
    FileUtils.logFile.flush();
  } // public static void main (String[] args)
} // public class Driver
