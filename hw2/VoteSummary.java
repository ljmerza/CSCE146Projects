/*********************************************************************
 * VoteSummary class that creates a new doubly linked list. Add and remove
 * records as well as does a search of a record in the DLL. A contains method to 
 * search if a particular record contains a string.
 *
 * @author Duncan A. Buell modifications by Leonardo Merza
 * @version 1.00 2011-01-22
**/
public class VoteSummary
{
/*********************************************************************
 * Instance variables for this class.
 **/
	private DLL<OneLine> dll;

/*********************************************************************
 * Constructor.
**/
  public VoteSummary()
  {
		this.dll = new DLL<OneLine>();
	} // public Phonebook()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>dll</code>.
 *
 * @return value of <code>dll</code>
**/
	public DLL<OneLine> getDll()
	{
		return this.dll;
	} // getDll method

/*********************************************************************
 * Method to set the <code>dll</code>.
 *
 * @param newDll the new value for the <code>dll</code>.
**/
	public void setDll(DLL<OneLine> newDll)
	{
		this.dll = newDll;
	} // setDll method

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a <code>OneLine</code> entry. This calls the add
 * in the VoteSummary class and returns true if the data was added.
 *
 * @param record the <code>Record</code> to add.
 *
 * @return true if the list changes, else false.
**/
  public boolean add(OneLine oneLine)
  {
		boolean isAdded = false;
		isAdded = dll.add(oneLine);
		return isAdded;
	} // add method

/*********************************************************************
 * Method to find if a list has a given record.
 *
 * @param record the <code>Record</code> to match against.
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(OneLine oneLine)
  {
		boolean hasContained = false;
		hasContained = dll.contains(oneLine);
		return hasContained;
	} // contains method

/*********************************************************************
 * Method to remove a node with a given record value.
 *
 * @param record the <code>Record</code> whose node is to be removed.
 *
 * @return the <code>boolean</code> that remove succeeded.
**/
  public boolean remove(OneLine oneLine)
  {
		boolean isRemoved = false;
		isRemoved = dll.remove(oneLine);
		return isRemoved;
	} // remove method

/*********************************************************************
 * Method to <code>toString</code> a complete OneLine.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
    String theString;
    theString = this.dll.toString();
    return theString;
	} // toString method
  
} // public interface IPhonebook