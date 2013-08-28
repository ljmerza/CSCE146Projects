import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 9: Spell checker.
 * This code is for building a HashSet based spell checker.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-03-26
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
    SpellChecker myChecker = null;

    FileUtils.setLogFile("zlog1");

    System.out.printf("%s begin execution%n",TAG);

    myChecker = new SpellChecker();
    inFile = FileUtils.ScannerOpen("dictionary.txt");
    myChecker.buildDictionary(inFile);
    FileUtils.closeFile(inFile);

    inFile = FileUtils.ScannerOpen("ztest");
    myChecker.checkSpelling(inFile);
    FileUtils.closeFile(inFile);

    FileUtils.closeFile(inFile);
    FileUtils.closeLogFile();

    System.out.printf("%s end execution%n",TAG);
  }
} // public class Driver

