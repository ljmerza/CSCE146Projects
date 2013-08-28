import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Copyright (C) 2008 by Duncan A. Buell.  All rights reserved.
 * Lab 4: Insertion sort
 *
 * This code is structured so that the driver does nothing but open 
 * and close files and call an intermediate class with a method
 * for doing all the work.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-02
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String classLabel = "Main: ";
    Scanner inFile = null;
    PrintWriter outFile = null;
    ManagedList myList = null;

    inFile = FileUtils.ScannerOpen("zin");
    outFile = FileUtils.PrintWriterOpen("zout");

    System.out.printf("%s begin execution%n",classLabel);

    myList = new ManagedList();
    myList.doTheWork(inFile, outFile);

    FileUtils.closeFile(inFile);
    FileUtils.closeFile(outFile);

    System.out.printf("%s end execution%n",classLabel);
  }
} // public class Driver

