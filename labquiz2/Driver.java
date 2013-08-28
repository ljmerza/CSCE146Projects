import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab Quiz2: Set containment and intersection.
 * This could be done withe the Java <code>Set</code> class, but
 * someone has to write that class, and this is how such things are
 * written.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-04-02
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";
    String myOutput = "";

    Scanner inFile = null;
    SetTesting mySetTester = null;

    FileUtils.setLogFile("zlog");

    System.out.printf("%s begin execution%n",TAG);

    mySetTester = new SetTesting();

// open the file with the control set, then read it, then close
// the file
    inFile = FileUtils.ScannerOpen("controlset");
    mySetTester.readControlSet(inFile);
    FileUtils.closeFile(inFile);

// open the file with the sets to test, then read them and test,
// then close the file
    inFile = FileUtils.ScannerOpen("setstotest.actual1");
    mySetTester.testTheSets(inFile);
    FileUtils.closeFile(inFile);

// print the results of the testing
    FileUtils.logFile.printf("%d sets tested%n",
                              mySetTester.getTestCount());
    FileUtils.logFile.printf("%d sets had nonempty intersection with control%n",
                              mySetTester.getIntersectionCount());
    FileUtils.logFile.printf("%d sets tested were subsets of control%n",
                              mySetTester.getSubsetCount());

    FileUtils.closeFile(inFile);
    FileUtils.closeLogFile();

    System.out.printf("%s end execution%n",TAG);
  }
} // public class Driver

