/*********************************************************************
 * Interface to describe a stack.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-21
**/
public interface IStack<T extends Comparable<T>>
{

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>size</code>
 *
 * @return the <code>int</code> value of <code>size</code>
**/
  public int getSize();

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to peek at the top entry on the stack.
 *
 * @return the <code>T</code> data from the top of the stack.
**/
  public T peek();

/*********************************************************************
 * Method to pop an entry from the top of a stack.
 *
 * @return the <code>T</code> data from the top of the stack.
**/
  public T pop();

/*********************************************************************
 * Method to push an entry onto the top of a stack.
 *
 * @param node the <code>T</code> data to add.
**/
  public void push(T node);

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head 
 * and tail nodes.
**/
  public String toString();

} // public interface IStack
