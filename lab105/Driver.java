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
 * @author Duncan A. Buell
 * @version 1.00 2011-02-14
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
	System.out.println("test");
    final String TAG = "Main: ";
    DominoGame myGame = null;

    System.out.printf("%s begin execution%n", TAG);

    myGame = new DominoGame();
    System.out.printf("%s entire list%n%s %n", TAG, myGame.toString());

    myGame.createHand();
    myGame.displayHand();

    System.out.printf("%s end execution%n", TAG);
  }
} // public class Driver

