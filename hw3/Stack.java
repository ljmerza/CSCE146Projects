/*********************************************************************
 * This Stack class works with a DLL to push and pull nodes from the dll
 * as well as to check the size of the dll and to see if it is empty.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza Section 001
 * @version 1.00 2011-02-11
**/
public class Stack<T extends Comparable<T>> implements IStack<T>
{
/*********************************************************************
 * Instance variables for this class.
**/
	private DLL<T> theDLL;
	private T top;
	
/*********************************************************************
 * Constructor.
**/
	 public Stack()
	 {
	  theDLL = new DLL<T>();
	 } // public Stack()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>size</code>
 *
 * @return the <code>int</code> value of <code>size</code>
**/
  public int getSize()
  {
  	int temp = theDLL.getSize();
  	return temp;
  } // getSize();

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to peek at the top entry on the stack.
 *
 * @return the <code>T</code> data from the top of the stack.
**/
  public T peek()
  {
  	top = theDLL.getHead().getNext().getNodeData();
  	return top;
  } // peek method

/*********************************************************************
 * Method to pop an entry from the top of a stack.
 *
 * @return the <code>T</code> data from the top of the stack.
**/
  public T pop()
  {
  	if( !(this.isEmpty()) )
  	{
  		top = theDLL.getHead().getNext().getNodeData();
  		theDLL.remove(theDLL.getHead().getNext().getNodeData());
  	} // if statement

  	return top;
  } // pop method

/*********************************************************************
 * Method to push an entry onto the top of a stack.
 *
 * @param node the <code>T</code> data to add.
**/
  public void push(T node)
  {
  	theDLL.add(node);
  } // push method

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head 
 * and tail nodes.
**/
  public String toString()
  {
  	String temp;
  	temp = theDLL.toString();
  	return temp;
  } // toString method

/*********************************************************************
 * This method will check the size of a dll to see if it is empty or not
 * 
 * @return boolean if the <code>dll</code> stack is empty of not.
**/
  public boolean isEmpty()
  {
  	boolean isItEmpty = false;
  	
  	if(this.getSize() == 2)
  	{
  		isItEmpty = true;
  	} // if statement
  	
  	return isItEmpty;
  } // isEmpty method

} // public class IStack
