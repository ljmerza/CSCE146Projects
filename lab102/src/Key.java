/*********************************************************************
 * Class to return the Key used in a search of the records
 *
 * @author Leonardo Merza
 * @version 1.00 2011-01-17
**/
public class Key
{
/*********************************************************************
 * Method to return the name of the key used to search the records
 *
 *@param the Record object the is being used to search
 * @return the <code>name</code>.
**/
	public static String getKey(Record name)
	{
		return name.getName();
	}
}