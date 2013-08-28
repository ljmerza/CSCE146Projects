import junit.framework.*;
import java.util.ArrayList;
/*********************************************************************
 *
**/
public class GameTester extends TestCase
{
  private String dummy = "";
//  private  rec1,rec2,rec3;
//  private DLLNode<Record> node1, node2, node3;
  private DominoGame theGame;

  private final int SIDEA = 0;
  private final int SIDEB = 1;

/*********************************************************************
 *
**/
  public GameTester(String name)
  {
    super(name);
  }

/*********************************************************************
 *
**/
  protected void setUp()
  {
    theGame = new DominoGame();
  }

/*********************************************************************
 *
**/
  protected void tearDown()
  {
    theGame = null;
  }

/*********************************************************************
 *
**/
  public void testConstructor()
  {
    System.out.println("Test the constructor");
    theGame = new DominoGame();
    theGame.createHand();

// we are going to rely here on the fact that the side a dotcount
// is always lessequal the side b dotcount
    for(int i = 0; i < 12; ++i)
    {
      for(int j = i+1; j <= 12; ++j)
      {
        int ia = theGame.getDomino(i).getDotcount(SIDEA);
        int ib = theGame.getDomino(i).getDotcount(SIDEB);
        int ja = theGame.getDomino(j).getDotcount(SIDEA);
        int jb = theGame.getDomino(j).getDotcount(SIDEB);
//        System.out.println("zoom " + ia + " " + ib + " " + ja + " " + jb);

        if((ia == ja) && (ib == jb))
        {
          assertNotSame(ia + ib*1000, ja + jb*1000);
// System.out.println("zork ");
        }
      }
    }
  }

/*********************************************************************
 *
**/
  public void testSizes()
  {
    System.out.println("Test setSizes");
    theGame = new DominoGame();
    assertEquals(91, theGame.listSize());
    theGame.createHand();
    assertEquals(12, theGame.handSize());
  }

/*********************************************************************
 *
**/
  public static Test suite()
  {
    return new TestSuite(GameTester.class);
  }

/*********************************************************************
 *
**/
  public static void main(String[] args)
  {
    String[] TestCaseName = {GameTester.class.getName()};
/*
    junit.swingui.testRunner.main(TestCaseName);
*/
  }
} // public class GameTester extends TestCase
