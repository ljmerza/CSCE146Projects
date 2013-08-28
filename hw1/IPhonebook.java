/*********************************************************************
 * Interface for the <code>Phonebook</code> class.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-01.11
**/
public interface IPhonebook
{
/*********************************************************************
 * Instance variables for this class.
 * The instance variable is given here, commented out, so you know
 * what you need for an instance variable.
**/
//  private DLL dll;

/*********************************************************************
 * Constructor.
 * Ditto the constructor, which can't appear in an
 * <code>interface</code> but is useful to remember.
**/
//  public Phonebook()
//  {
//    this.dll = new DLL();
//  } // public Phonebook()

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
  public boolean add(Record record);

/*********************************************************************
 * Method to find if a list has a given record. 
 *
 * @param record the <code>Record</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(Record record);

/*********************************************************************
 * Method to remove a node with a given record value. 
 *
 * @param record the <code>Record</code> whose node is to be removed.
 *
 * @return the <code>boolean</code> that remove succeeded.
**/
  public boolean remove(Record record);

/*********************************************************************
 * Method to <code>toString</code> a complete Phonebook.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString();

} // public interface IPhonebook
