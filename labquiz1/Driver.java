import java.util.Scanner;
/*********************************************************************
 * Driver for the Lab quiz 1 code.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-07
**/
public class Driver
{
  public static void main (String[] args)
  {
    final String classLabel = "Driver: ";

    Scanner inFile = null;
    ManagedList theManagedList = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.setLogFile("zlog");

    //********************************************************************
    // Create the list of data items.
    // Read the data.
    // Write the list as read.
    // Sort the list.
    // Write the sorted list.
    // Close up and go home.
    //
    FileUtils.logFile.printf("%s create the list%n", classLabel);
    theManagedList = new ManagedList();

    FileUtils.logFile.printf("%s read data%n", classLabel);
    theManagedList.readFile(inFile);

    FileUtils.logFile.printf("%s the list as read was%n%s%n",
                             classLabel, theManagedList.toString());

    theManagedList.sortTheList();
    FileUtils.logFile.printf("%s the sorted list is%n%s%n",
                             classLabel, theManagedList.toString());

    FileUtils.closeLogFile();
    FileUtils.logFile.printf("%s done with main%n",classLabel);
  }
} // public class Driver
