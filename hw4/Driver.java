import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 5: Domino game setup and JUnit testing
 *
 * This code is structured so that the driver does nothing but
 * create an instance of the dominoes game and then call a method
 * to create and display a hand.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-14
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";
    DominoGame myGame = null;

    FileUtils.setLogFile("zlog");
    FileUtils.logFile.printf("%s begin execution%n", TAG);

    myGame = new DominoGame();
    FileUtils.logFile.printf("%s entire list%n%s %n", TAG, myGame.toString());

    myGame.createHand();
//    myGame.displayHand();

    for(int start = 0; start < Constants.HANDSIZE; ++start)
//    for(int start = 0; start < 1; ++start)
    {
    	FileUtils.logFile.printf("%s longest chain from start %d is of length %d%n",
                               TAG, start, myGame.getLongestChain(start));
    }

    FileUtils.logFile.printf("%s end execution%n", TAG);
    FileUtils.logFile.flush();
  }
} // public class Driver

