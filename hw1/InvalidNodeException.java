/*********************************************************************
 * Invalid Node Exception if searching for a node with a null value
 *
 * @author Leonardo Merza
 * @version 1.00 2011-01-22
**/

public class InvalidNodeException extends RuntimeException
{
/*********************************************************************
* Constructors.
**/
	public InvalidNodeException()
	{
		super();
	} // InvalidNodeException constructor
	
	public InvalidNodeException(String aString)
	{
		super(aString + " error message");
	}
} // InvalidNodeException class
