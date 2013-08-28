import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
/*********************************************************************
 *
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

    myAssembler = new PacketAssembler();
    inFile = FileUtils.ScannerOpen("zpackets.homeworkinput");
    myAssembler.assemblePackets(inFile);
    FileUtils.closeFile(inFile);

    FileUtils.closeFile(inFile);
    FileUtils.closeLogFile();

    System.out.printf("%s end execution%n",TAG);
  }
} // public class Driver

