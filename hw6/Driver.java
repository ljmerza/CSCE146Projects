// import java.util.ArrayList;
// import java.util.Random;
import java.util.Scanner;
/*********************************************************************
 * Homework 6:  Implement a binary search tree for doing a
 *              dictionary lookup.
 *
 * Copyright(C) 2011 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-03-25
**/
public class Driver
{
/*********************************************************************
 * main method
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";
    Scanner inFile = null;
    Scanner testFile = null;
    Record rec = null;
    Record testRec;
    BST<Record> theTree;

    inFile = FileUtils.ScannerOpen("zin.sorted");
    FileUtils.setLogFile("zlog");

    /*********************************************************************
     * First we build the tree of the dictionary.
    **/
    theTree = new BST<Record>();
    while(inFile.hasNext())
    {
      rec = new Record();
      rec = rec.readRecord(inFile);
      if(rec.isAlpha())
      {
        FileUtils.logFile.printf("%s is alpha, insert '%s'%n", TAG,
                  rec.getElement());
        FileUtils.logFile.flush();
        theTree.insert(rec);
      }
      else
      {
        FileUtils.logFile.printf("%s NOT ALPHA, skip '%s'%n", TAG,
                  rec.getElement());
        FileUtils.logFile.flush();
      }
    } // while(inFile.hasNext())

    /*********************************************************************
     * We have finished reading the input data, so we echo the list.
    **/
    FileUtils.logFile.printf("%s The inorder tree of all %d items%n%s%n", TAG,
              theTree.getNodeCount(),theTree.toStringInorder(theTree.getRoot()));
    
    FileUtils.logFile.flush();
    
    FileUtils.logFile.printf("%s The average height of %d nodes is %f%n", TAG,
              theTree.getNodeCount(), theTree.getAverageHeight());
    theTree.writeHeightHisto();
    FileUtils.logFile.flush();

/*
    FileUtils.logFile.printf("%s The preorder tree of all %d items%n%s%n", TAG,
              theTree.getSize(),theTree.toStringPreorder(theTree.getRoot()));
    FileUtils.logFile.flush();

    FileUtils.logFile.printf("%s The postorder tree of all %d items%n%s%n", TAG,
              theTree.getSize(),theTree.toStringPostorder(theTree.getRoot()));
*/
    FileUtils.logFile.flush();
    FileUtils.closeFile(inFile);

    /*********************************************************************
     * Now we run the lookup on the test file.
    **/
    testFile = FileUtils.ScannerOpen("ztest");
    while(testFile.hasNext())
    {
      testRec = new Record();
      testRec = testRec.readRecord(testFile);
      FileUtils.logFile.printf("%s The test record is '%s'%n", TAG,
                testRec.toString());
      FileUtils.logFile.flush();
      if(theTree.contains(testRec))
      {
        FileUtils.logFile.printf("%s The test record '%s' is in the tree%n%n", TAG,
                  testRec.toString());
        FileUtils.logFile.flush();
      }
      else
      {
        FileUtils.logFile.printf("%s The test record '%s' is NOT in the tree%n%n",
                  TAG,testRec.toString());
        FileUtils.logFile.flush();
      }
    } // while(testFile.hasNext())

    /*********************************************************************
     * Close up, go home.
    **/
    FileUtils.logFile.printf("%s no more data, terminate%n",TAG);
    FileUtils.logFile.flush();
    
    FileUtils.closeLogFile();
  }
} // public class Main





