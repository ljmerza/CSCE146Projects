import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
/*********************************************************************
 * Lab 10: Packet assembler. 
 * This code is for building a TreeMap and HashSet based program
 * for assembling Internet packets from a stream of input data.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell by Leonardo Merza Section 001
 * @version 1.00 2011-04-09
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";

    Scanner inFile = null;
    PacketAssembler myAssembler = null;

    FileUtils.setLogFile("zlog");

    System.out.printf("%s begin execution%n",TAG);

/*
    Random random = new Random();
    for(int i = 0; i < 5; ++i)
    {
      for(int j = 0; j < 20; ++j)
      {
        int r = random.nextInt();
        r = ((r % 1000) + 1000) % 1000;
        FileUtils.logFile.printf("%8d %8d xxxx yyyy%n", r, j);
      }
    }
*/

    myAssembler = new PacketAssembler();
    inFile = FileUtils.ScannerOpen("zpackets");
    myAssembler.assemblePackets(inFile);
    FileUtils.closeFile(inFile);

    FileUtils.closeFile(inFile);
    FileUtils.closeLogFile();

    System.out.printf("%s end execution%n",TAG);
  }
} // public class Driver

