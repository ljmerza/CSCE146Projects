import java.util.Scanner;
/*********************************************************************
 * Driver for HW 2 using generics, a DLL, and vote data.
 *
 * This is essentially the same as HW 1, except that we use generics
 * and we substitute vote data for the data payload class.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-09
**/
public class Driver34
{
/*********************************************************************
 * Instance variables for the class.
**/
  public static final String ADD = "add";
  public static final String CONTAINS = "contains";
  public static final String REMOVE = "remove";

/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String classLabel = "Driver: ";
    String control = "";
    Scanner inFile = null;
    VoteSummary voteSummary = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.setLogFile("zlog");

    FileUtils.logFile.printf("%s beginning%n", classLabel);

    voteSummary = new VoteSummary();
    FileUtils.logFile.printf("%s the empty voteSummary is%n%s%n",
                             classLabel, voteSummary.toString());
    FileUtils.logFile.flush();

    voteSummary.readData(inFile);

    FileUtils.logFile.printf("%s the voteSummary is now%n%s%n",
                             classLabel, voteSummary.toString());

    FileUtils.logFile.printf("%s ending%n", classLabel);
    FileUtils.logFile.flush();

  } // public static void main (String[] args)
} // public class Driver
