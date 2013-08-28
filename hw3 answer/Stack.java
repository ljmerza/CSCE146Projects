/*********************************************************************
 * Implementation of a stack using the interface.
 *
 * This is a standard stack using a generic underlying DLL.
 * We rely on the DLL methods to do the real work, and all these
 * stack methods (push, pop, etc.) do is serve as a wrapper for
 * the methods in the DLL.
 *
 * Copyright (C) by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell
**/

public class Stack<T extends Comparable<T>> implements IStack<T>
{

  DLL<T> theDLL = null;

  public Stack()
  {
    theDLL = new DLL<T>();
  }

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * Method to get the <code>size</code>.
 *
 * @return the <code>int</code> value of <code>size</code>.
**/
  public int getSize()
  {
    return theDLL.getSize();
  }

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to peek at the data on the top node of a stack.
 *
 * @return the <code>T</code> data that is peeked at.
**/
  public T peek()
  {
    DLLNode<T> returnNode = null;
    T returnValue = null;

    returnNode = this.theDLL.getHead().getNext();
    returnValue = returnNode.getNodeData();
    return returnValue;
  }

/*********************************************************************
 * Method to pop the data from the top node of a stack.
 *
 * @return the <code>T</code> data that is popped.
**/
  public T pop()
  {
    DLLNode<T> returnNode = null;
    T returnValue = null;

    returnNode = this.theDLL.getHead().getNext();
    returnValue = returnNode.getNodeData();
    this.theDLL.remove(returnValue);
    return returnValue;
  }

/*********************************************************************
 * Method to push an entry node onto the top of a stack.
 *
 * @param node the <code>DLLNodeData</code> to add.
**/
  public void push(T nodeData)
  {
    this.theDLL.addAtHead(nodeData);
  }

/*********************************************************************
 * Method to <code>toString</code> a complete stack.
**/
  public String toString()
  {
    return "stack toString not implemented";
  }

} // public class Stack<T extends Comparable<T>> implements IStack<T>
