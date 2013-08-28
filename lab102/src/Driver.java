import java.util.Scanner;
/*********************************************************************
 * Driver for the phonebook program using an array.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-11
**/
public class Driver
{
  public static void main (String[] args)
  {
    final String classLabel = "Driver: ";

    final int RECORDMAX = 20; /** num of record spaces to allocate */
    int count;                /** num of input records or searches */
    int searchSubscript;      /** subscript of record searched for */
    String theKey = "";       /** 'String' version of a search key */
    Scanner inFile = null;
    FlatFile theFlatFile = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.setLogFile("zlogfile");

    /*********************************************************************
     * Create the flat file, then write it out to show that it's empty.
    **/
    FileUtils.logFile.printf("%s create the flat file and write it%n",
                              classLabel);
    theFlatFile = new FlatFile(RECORDMAX);
    FileUtils.logFile.printf("%s file created is%n%s%n",
                             classLabel, theFlatFile.toString());
    FileUtils.logFile.printf("%s empty file was created%n", classLabel);

    /*********************************************************************
     * Now read the data.
    **/
    count = inFile.nextInt();
    FileUtils.logFile.printf("%s read %d records%n", classLabel, count);
    theFlatFile.readFile(count, inFile);
    FileUtils.logFile.printf("%s %d records have been read%n",
                             classLabel, count);

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
    count = inFile.nextInt();
    for(int i = 0; i < count; ++i)
    {
      theKey = inFile.next(); // read 'theKey' as a 'String'
      FileUtils.logFile.printf("%s search for key '%s'%n",
                               classLabel, theKey);
      searchSubscript = theFlatFile.findRecordWithKey(theKey);
      if(searchSubscript > 0)
      {
        FileUtils.logFile.printf("%s name '%s' appears as%n%s%n",
                                 classLabel, theKey.toString(),
                                 theFlatFile.getRecord(searchSubscript));
      }
      else
      {
        FileUtils.logFile.printf("%s name '%s' not in the file %n",
                                 classLabel, theKey.toString());
      }
      FileUtils.logFile.printf("%s done with search %d%n",
                               classLabel, i);
    } // for(int i = 0; i < count; ++i)

    /*********************************************************************
     * We're done.  Close up and go home.
    **/
    FileUtils.closeLogFile();
    FileUtils.logFile.printf("%s done with main%n",classLabel);
  }
} // public class Driver
