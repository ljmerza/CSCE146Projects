import java.util.Scanner;
/*********************************************************************
 * Driver for HW 1 on singly linked lists.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-11
**/
public class Driver
{
/*********************************************************************
 * Instance variables for the class.
**/
  public static final String ADD = "add";
  public static final String CONTAINS = "contains";
  public static final String REMOVE = "remove";

/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String classLabel = "Driver: ";
    String control = "";
    Scanner inFile = null;
    Record record = null;
    Phonebook phonebook = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.setLogFile("zlog1");

    FileUtils.logFile.printf("%s beginning%n", classLabel);

    phonebook = new Phonebook();
    FileUtils.logFile.printf("%s the empty phonebook is%n%s%n",
                             classLabel, phonebook.toString());
    FileUtils.logFile.flush();

    // run the loop on the input data
    while(inFile.hasNext())
    {
      control = inFile.next();
      record = Record.readRecord(inFile);

      //
      // if we have an 'add', then add the record and verify
      // that the add changed the collection
      //
      if(0 == control.compareTo(ADD))
      {
        FileUtils.logFile.printf("%s ADD record '%s'%n",
                                 classLabel, record.toString());
        if(phonebook.add(record))
        {
          FileUtils.logFile.printf("%s yes, added record '%s'%n",
                                   classLabel,
                                   record.toString());
        }
        else
        {
          FileUtils.logFile.printf("%s no, did not add '%s'%n",
                                   classLabel,
                                   record.toString());
        }
      } // if(0 == control.compareTo(ADD))
      //
      // if we have a 'contains', then we test and respond
      //
      else if(0 == control.compareTo(CONTAINS))
      {
        FileUtils.logFile.printf("%s CONTAINS? '%s'%n",
                                 classLabel, record.toString());
        FileUtils.logFile.flush();
        if(phonebook.contains(record))
        {
          FileUtils.logFile.printf("%s yes, list contains '%s'%n",
                                   classLabel,
                                   record.toString());
        }
        else
        {
          FileUtils.logFile.printf("%s no, list does not contain '%s'%n",
                                   classLabel,
                                   record.toString());
        }
      } // else if(0 == control.compareTo(CONTAINS))
      //
      // if we have a 'remove', then we remove if possible and inform
      // the user of the result
      //
      else if(0 == control.compareTo(REMOVE))
      {
        FileUtils.logFile.printf("%s REMOVE '%s'%n",
                                 classLabel, record.toString());
        if(phonebook.remove(record))
        {
          FileUtils.logFile.printf("%s successfully removed '%s'%n",
                                   classLabel,
                                   record.toString());
        }
        else
        {
          FileUtils.logFile.printf("%s removal failed of '%s'%n",
                                   classLabel,
                                   record.toString());
        }
      } // else if(0 == control.compareTo(REMOVE))
      //
      // if the command is invalid, we ignore and continue
      //
      else
      {
        FileUtils.logFile.printf("%s ERROR invalid control '%s', ignore%n",
                                 classLabel, control);
        FileUtils.logFile.flush();
      } // else

      FileUtils.logFile.printf("%s the phonebook is now%n%s%n",
                               classLabel, phonebook.toString());
      FileUtils.logFile.flush();
    } // while(inFile.hasNext())

    FileUtils.logFile.printf("%s ending%n", classLabel);
    FileUtils.logFile.flush();

  } // public static void main (String[] args)
} // public class Driver
