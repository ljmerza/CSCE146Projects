import java.util.Scanner;
/*********************************************************************
 * Copyright (C) 2008 by Duncan A. Buell.  All rights reserved.
 * Driver for example 01, the phonebook program using an array.
 *
 * @author Duncan A. Buell
 * @version 1.00 2008-12-15
**/
public class Driver
{
  public static void main (String[] args)
  {
    final String classLabel = "Driver: ";

    int searchSubscript;
    Scanner inFile = null;
    FlatFile theFlatFile = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.setLogFile("zlogfile");

    /*********************************************************************
     * Create the flat file, then write it out to show that it's empty.
    **/
    FileUtils.logFile.printf("%s create the flat file and write it%n",
                              classLabel);
    theFlatFile = new FlatFile(20);
    FileUtils.logFile.printf("%s file created is%n%s%n",
                             classLabel, theFlatFile.toString());
    FileUtils.logFile.printf("%s empty file was created%n", classLabel);

    /*********************************************************************
     * Now read the data.
    **/
    FileUtils.logFile.printf("%s read the data%n", classLabel);
    theFlatFile.readFile(inFile);
    FileUtils.logFile.printf("%s data has been read%n", classLabel);

    /*********************************************************************
     * And then print out the data as read.
    **/
    FileUtils.logFile.printf("%s write the file as read%n", classLabel);
    FileUtils.logFile.printf("%s file read was%n%s%n",
                             classLabel, theFlatFile.toString());
    FileUtils.logFile.printf("%s done with the write%n", classLabel);

    /*********************************************************************
     * Now we search for some names.
    **/
    FileUtils.logFile.printf("%s search for name 'Smith'%n", classLabel);
    searchSubscript = theFlatFile.findName("Smith");
    if(searchSubscript > 0)
    {
      FileUtils.logFile.printf("%s name 'Smith' appears as%n%s%n",
                               classLabel,
                               theFlatFile.getRecord(searchSubscript).
                                   toString());
    }
    else
    {
      FileUtils.logFile.printf("%s name 'Smith' not in the file %n",
                               classLabel);
    }
    FileUtils.logFile.printf("%s done with the first search%n",
                              classLabel);

    FileUtils.logFile.printf("%s search for name 'Buell'%n", classLabel);
    searchSubscript = theFlatFile.findName("Buell");
    if(searchSubscript > 0)
    {
      FileUtils.logFile.printf("%s name 'Buell' appears as%n%s%n",
                               classLabel,
                               theFlatFile.getRecord(searchSubscript).
                                   toString());
    }
    else
    {
      FileUtils.logFile.printf("%s name 'Buell' not in the file %n",
                               classLabel);
    }
    FileUtils.logFile.printf("%s done with the second search%n",
                              classLabel);

    /*********************************************************************
     * We're done.  Close up and go home.
    **/
    FileUtils.closeLogFile();
    FileUtils.logFile.printf("%s done with main%n",classLabel);
  }
} // public class Driver
