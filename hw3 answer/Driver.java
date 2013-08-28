import java.util.Scanner;
/*********************************************************************
 * Homework 3:  Do a Stack to parse XML for validity.
 *
 * In this program we will create a parser instance, open a file,
 * and then use a stack to test in the parser whether the file 
 * is properly formed XML.
 *
 * Copyright (c) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell
 * @version 1.00 2011-01-11
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
    XMLParser xmlparser = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.setLogFile("zlog");

    xmlparser = new XMLParser();
    if(xmlparser.checkValidXML(inFile))
    {
      FileUtils.logFile.printf("%s XML is valid%n", classLabel);
    }
    else
    {
      FileUtils.logFile.printf("%s XML is NOT valid%n", classLabel);
    }

    FileUtils.logFile.printf("%s no more data, terminate%n", classLabel);
    
    FileUtils.closeLogFile();
  }
} // public class Main

