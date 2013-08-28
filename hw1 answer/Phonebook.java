/*********************************************************************
 * Class to implement a simple phonebook application.
 * This uses a DLL structure that is the only instance variable,
 * and then uses the builtin methods of the DLL.
 * This code has methods
 *   <code>add</code>,
 *   <code>contains</code>,
 *   <code>remove</code>,
 *   <code>toString</code>,
 * that are simply wrappers for methods of the same name in the DLL.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01-11
**/
public class Phonebook implements IPhonebook
{
/*********************************************************************
 * Instance variables for this class.
**/
//  private static final String classLabel = "PhoneBook: ";
  private DLL dll;

/*********************************************************************
 * Constructor.
**/
  public Phonebook()
  {
    this.dll = new DLL();
  } // public Phonebook()

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to add a <code>Phonebook</code> entry.
 * This simply calls the DLL <code>add</code> method.  Therefore,
 * what we are really doing here is converting the <code>add</code>
 * of a <code>Record</code> item to the <code>Phonebook</code> into
 * the addition of a node with that <code>Record</code> as data
 * payload into the <code>DLL</code>.
 *
 * @param record the <code>Record</code> to add.
 *
 * @return true if the list changes, else false.
**/
  public boolean add(Record record)
  {
    return this.dll.add(record);
  } // public boolean add(Record record)

/*********************************************************************
 * Method to find if a list has a given record. 
 *
 * @param record the <code>Record</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(Record record)
  {
    return this.dll.contains(record);
  } // public boolean contains(Record record)

/*********************************************************************
 * Method to remove a node with a given record value. 
 *
 * @param record the <code>Record</code> whose node is to be removed.
 *
 * @return the <code>boolean</code> that remove succeeded.
**/
  public boolean remove(Record record)
  {
    return this.dll.remove(record);
  } // public boolean remove(Record record)

/*********************************************************************
 * Method to <code>toString</code> a complete Phonebook.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
    String s = "";
    s = this.dll.toString();
    return s;
  } // public String toString()

} // public class Phonebook implements IPhonebook
