import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 6: The Collatz conjecture.
 * This code is for testing that something is true, and thus it is
 * somewhat less general than one might expect.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-02-26
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";

    int beginValue; // first value to test
    int endValue; // last value to test
    int maxStepsTaken; // the current max number of steps taken
    int steps; // the number of steps taken for a single test

    Scanner inFile = null;
    Collatz collatz = null;

    inFile = FileUtils.ScannerOpen("zin.a");
    FileUtils.setLogFile("zlog");

    System.out.printf("%s begin execution%n",TAG);

    // read in the beginning and ending values
    // in this case we do not bulletproof the read
    // the program will just die if we read a non-integer
    beginValue = inFile.nextInt();
    endValue = inFile.nextInt();

    maxStepsTaken = 0;
    collatz = new Collatz();
    FileUtils.logFile.printf("%s Test Collatz from %d through %d%n",
                              TAG, beginValue, endValue);
    for(int n = beginValue; n <= endValue; ++n)
    {
      collatz.resetStepCount();
      collatz.testTheConjecture(n);
      steps = collatz.getStepCount();
      if(steps < 0)
      {
        FileUtils.logFile.printf("%s TEST FAILS FOR %d%n", TAG, n);
      }
      else if(steps > maxStepsTaken)
      {
        maxStepsTaken = steps;
        FileUtils.logFile.printf("%s NEW MAX STEPS %d FOR n=%d%n",
                                  TAG, maxStepsTaken, n);
      }
    }

    FileUtils.closeFile(inFile);
    FileUtils.closeLogFile();

    System.out.printf("%s end execution%n",TAG);
  }
} // public class Driver

