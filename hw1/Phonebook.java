/*********************************************************************
 * Phonebook class that creates a new doublely linked list. Add and remove
 * records as well as does a search of a record in the DLL. A contains method to 
 * search if a particular record contains a string.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza
 * @version 1.00 2011-01-22
**/
public class Phonebook implements IPhonebook
{
/*********************************************************************
 * Instance variables for this class.
 **/
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
 * Method to get the <code>dll</code>.
 *
 * @return value of <code>dll</code>
**/
	public DLL getDll()
	{
		return this.dll;
	} // getDll method

/*********************************************************************
 * Method to set the <code>dll</code>.
 *
 * @param newDll the new value for the <code>dll</code>.
**/
	public void setDll(DLL newDll)
	{
		this.dll = newDll;
	} // setDll method

/*********************************************************************
 * General methods.
**/

/*********************************************************************
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
		boolean isAdded = false;
		isAdded = dll.add(record);
		return isAdded;
	} // add method

/*********************************************************************
 * Method to find if a list has a given record.
 *
 * @param record the <code>Record</code> to match against.
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(Record record)
  {
		boolean hasContained = false;
		hasContained = dll.contains(record);
		return hasContained;
	} // contains method

/*********************************************************************
 * Method to remove a node with a given record value.
 *
 * @param record the <code>Record</code> whose node is to be removed.
 *
 * @return the <code>boolean</code> that remove succeeded.
**/
  public boolean remove(Record record)
  {
		boolean isRemoved = false;
		isRemoved = dll.remove(record);
		return isRemoved;
	} // remove method

/*********************************************************************
 * Method to <code>toString</code> a complete Phonebook.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
	  DLLNode current = new DLLNode();
	  current = dll.getHead().getNext();
	  String theString;
	  theString = "There are " + dll.getSize() + " entries\n";
	  theString += "going forward\n";
	  
	  current = dll.getTail().getPrev();
	  theString += String.format("%3d: %s %n", 0, "Dummy Node");
	  for(int i = 2; i < dll.getSize(); i++)
  	  {
  			theString += String.format("%3d: %s %n", i - 1 ,current.getNodeData().toString());
  			current = current.getPrev();
  	  } // for statement
  	  theString += String.format("%3d: %s %n", dll.getSize() - 1, "Dummy Node");  

  	  
	  current = dll.getHead().getNext();
	  theString += "\ngoing backward\n";
	  theString += String.format("%3d: %s %n", 0, "Dummy Node");
	  for(int i = 2; i < dll.getSize(); i++)
	  {
			theString += String.format("%3d: %s %n", i - 1 ,current.getNodeData().toString());
			current = current.getNext();
	  } // for statement
	  theString += String.format("%3d: %s %n", dll.getSize() - 1, "Dummy Node");
	  
	  
	  

  	  
  	  
	  return theString;
	} // toString method
  
} // public interface IPhonebook