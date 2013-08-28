import java.util.Scanner;
/*********************************************************************
 * Class for parsing XML and checking for correctness.
 *
 * The parser uses a stack and processes the input file using the
 * stack.  Tokens are scanned, identified as open tags, close tags,
 * or data, and the node data instance is pushed onto the stack if
 * it is either an open tag or just data. 
 *
 * We are operating under a very restricted sense of XML here, in
 * which there are no attributes permitted and the tags are assumed 
 * to always be either
 *     <code><tagname></code>
 * or
 *     <code></tagname></code>
 * with nothing else inside the angle brackets.
 *
 * We implement methods to test for open and close tags and a
 * method to extract the string from inside the tag.
 *
 * Further details on processing are found in the documentation
 * for the <code>checkValidXML</code> method.
 *
 * Copyright (C) by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell
**/
public class XMLParser
{
/*********************************************************************
 * Instance variables for the class.
**/
  private final String classLabel = "XMLParser: ";

  Stack<DLLNodeData> theStack = null;

/*********************************************************************
 * Constructor.
**/
  public XMLParser()
  {
    theStack = new Stack<DLLNodeData>();
  } // public XMLParser()

/*********************************************************************
 * Accessors and mutators. (none)
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to check XML in an input file for validity.
 *
 * This is the workhorse method of this class.
 * We scan a file until there is nothing more to scan or until we
 * determine that the XML is not properly formed.
 *
 * In the scanning loop, we scant the next token as a raw string.
 * NOTE: WE ASSUME NO BLANK SPACES.
 * We then test whether this is an open tag, a close tag, or data.
 *
 * If it is an open tag we extract the tag name and push the node data
 * instance on the stack.
 *
 * If it is just data, we push the node data instance on the stack.
 *
 * If it is a close tag, we pop the stack until we get an open tag,
 * and the XML is properly formed or not depending on whether the open
 * matches the close.
 *
 * @param inFile the <code>Scanner</code> from which to read.
 * @return a <code>boolean</code> according as to valid or not
**/
  public boolean checkValidXML(Scanner inFile)
  {
    boolean returnValue;
    int depth = 0;
    String dataString = "";
    String sParsed = "",sRaw = "";
    DLLNodeData nodeData = new DLLNodeData(); 

    FileUtils.logFile.printf("%s enter checkValidXML%n",classLabel);
    FileUtils.logFile.flush();

    returnValue = true;
    // Loop until no more data.
    while(inFile.hasNext())
    {
      nodeData = new DLLNodeData(); 
      sRaw = inFile.next();
//      FileUtils.logFile.printf("%s raw token: '%s' %n",
//                   classLabel,sRaw);
//      FileUtils.logFile.flush();

      // If an open tag, process the tag and then push it on the stack.
      if(this.isOpenToken(sRaw))
      {
        ++depth;
        sParsed = this.getToken(sRaw);
//        FileUtils.logFile.printf("%s open token:  '%s'%n",
//                     classLabel,sParsed);
//        FileUtils.logFile.flush();
        nodeData.setTokenOpen(true);
        nodeData.setTokenClose(false);
        nodeData.setTokenData(false);
        nodeData.setSRaw(sRaw);
        nodeData.setSParsed(sParsed);
//        FileUtils.logFile.printf("%s node data %s%n",
//                     classLabel,node.toString());
//        FileUtils.logFile.flush();
        this.theStack.push(nodeData);
      } // if(this.isOpenToken(sRaw))

      // If a close tag, pop the stack looking for the first open.
      else if(this.isCloseToken(sRaw))
      {
        sParsed = this.getToken(sRaw);
//        FileUtils.logFile.printf("%s close token: '%s'%n",
//                     classLabel,sParsed);
//        FileUtils.logFile.flush();
        nodeData = this.theStack.pop();
        if(nodeData.getSParsed().equals(sParsed))
        {
          FileUtils.logFile.printf("%s",classLabel);
          for(int i = 0; i < depth; ++i)
          {
            FileUtils.logFile.printf("X ");
          }
          FileUtils.logFile.printf("tag %d '%s': '%s'%n",
                       depth,sParsed,dataString);
          FileUtils.logFile.flush();
          dataString = "";
          --depth;
        }
        else // close doesn't match open, invalid XML
        {
          FileUtils.logFile.printf("%s ERROR close '%s' != open '%s'%n",
                       classLabel,sParsed,nodeData.getSParsed());
          FileUtils.logFile.flush();
          returnValue = false;
          break;
        }
      } // else if(this.isCloseToken(sRaw))

      // If neither open nor close tag, it is data and we push on the stack.
      else
      {
        sParsed = sRaw;
        dataString = dataString + " " + sParsed;
//        FileUtils.logFile.printf("%s just data:   '%s' '%s'%n",
//                     classLabel,sParsed,dataString);
//        FileUtils.logFile.flush();
      }
    } // while(inFile.hasNext())

    FileUtils.logFile.printf("%s leave checkValidXML%n",classLabel);
    FileUtils.logFile.flush();

    return returnValue;
  } // public boolean checkValidXML(Scanner inFile)

/*********************************************************************
 * Method to get the token inside the angle brackets.
 *
 * @param s the <code>String</code> from which to extract the actual token.
 * @return the extracted token.
**/
  private String getToken(String s)
  {
    String ss = "";

    ss = s.substring(0,s.length()-1);
    ss = ss.substring(1);
    if(0 == ss.substring(0,1).compareTo("/"))
    {
      ss = ss.substring(1);
    }

    return ss;
  } // private String getToken(String s)

/*********************************************************************
 * Method to test whether a <code>String</code> is a close token.
 *
 * @param s the <code>String</code> to test.
 * @return the answer to the question.
**/
  private boolean isCloseToken(String s)
  {
    boolean returnValue = false;

    if(s.length() >= 2)
    {
      if( (0 == s.substring(0,2).compareTo("</")) &&
          (0 == s.substring(s.length()-1).compareTo(">")))
      {
        returnValue = true;
      }
    }

    return returnValue;
  } // private boolean isCloseToken(String s)

/*********************************************************************
 * Method to test whether a <code>String</code> is an open token.
 *
 * @param s the <code>String</code> to test.
 * @return the answer to the question.
**/
  private boolean isOpenToken(String s)
  {
    boolean returnValue = false;

    if(s.length() >= 1)
    {
      if( (0 == s.substring(0,1).compareTo("<")) &&
          (0 != s.substring(1,2).compareTo("/")) &&
          (0 == s.substring(s.length()-1).compareTo(">")))
      {
        returnValue = true;
      }
    }

    return returnValue;
  } // private boolean isOpenToken(String s)

} // public class XMLParser
