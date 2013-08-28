import junit.framework.*;
import java.util.Scanner;
/*********************************************************************
*
**/
public class DominoTester extends TestCase
{
	private DominoGame dom;
/*********************************************************************
*
**/
	protected void setUp()
	{
		dom = new DominoGame();
		dom.createHand();
	}
/*********************************************************************
*
**/
	protected void tearDown()
	{
		dom = null;
	}
/*********************************************************************
*
**/
	public void testDominoNumber()
	{
		System.out.println("Check total number of dominoes");
		assertEquals(91, dom.getTheList().size());
	}
	
	public void testDominoHand()
	{
		System.out.println("Check total number of dominoes");
		assertEquals(12, dom.getTheHand().size());
	}
	
}