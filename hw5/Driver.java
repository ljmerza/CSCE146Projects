import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 7: Reading vote data and counting votes the hard way.
 * This code is structured so the data is read one line at a time
 * into an <code>ArrayList</code> and then the data (for some
 * contests) is processed to produce vote totals.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-03-03
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";
    Scanner inFile = null;
    PrintWriter outFile = null;
    VoteCounter myList = null;

    inFile = FileUtils.ScannerOpen("zzz378");
    outFile = FileUtils.PrintWriterOpen("zout");

    System.out.printf("%s begin execution%n",TAG);

    myList = new VoteCounter();
    myList.doTheWork(inFile, outFile);

    FileUtils.closeFile(inFile);
    FileUtils.closeFile(outFile);

    System.out.printf("%s end execution%n",TAG);
  }
} // public class Driver

