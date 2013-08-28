
/*********************************************************************
 *
 * @author Leonardo Merza
 * @version 1.00
**/
public class Collatz
{
/*********************************************************************
 * Instance variables.
**/
	private int stepCount;
/*********************************************************************
 * Accessor and Mutator Methods methods
**/
/*********************************************************************
* Method to get the step count
**/
	public int getStepCount() 
	{
		return stepCount;
	} // public int getStepCount() 

/*********************************************************************
 * Method to reset step count to zero
**/
	public void resetStepCount() 
	{
		this.stepCount = 0;
	} // public void resetStepCount() 
	
/*********************************************************************
 * General Methods
**/
/*********************************************************************
 * Method to test the conjecture
 * 
 * @param the integer that will be used 
**/
	public void testTheConjecture(int NumberUsed)
	{
		if(NumberUsed <= 1)
		{
			return;
		} // if statement
		else
		{
			if(NumberUsed % 2 == 0)
			{
				stepCount++;
				this.testTheConjecture(NumberUsed/2);
			} // if statement
			else
			{
				stepCount++;
				this.testTheConjecture((3 * NumberUsed) + 1);
			} // else statement
		} // else statement
	} // public void testTheConjecture(int NumberUsed)
	
} // Class Collatz