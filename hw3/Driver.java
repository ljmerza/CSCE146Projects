import java.util.Scanner;
/*********************************************************************
 * Homework 3:  Do a Stack to parse XML for validity.
 *
 * Copyright (c) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-11
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

