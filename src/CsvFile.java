import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
The CsvFile class reads and writes CSV files.
*/

public class CsvFile 
{
	private static String inputFile;
	private List<User> users;
	
	public CsvFile (String filename) throws IOException
	{
		inputFile = filename;
	}
	
	public List<User> readCsv()
	{
		BufferedReader reader = null;
		try 
		{
			users = new ArrayList<User>();
			String line = "";
			reader = new BufferedReader(new FileReader(inputFile));
			reader.readLine();
	   
			while((line = reader.readLine()) != null) 
			{
				String[] fields = line.split(",");
				if(fields.length > 0)  
				{
					User user = new User();						// Creates new User object
				    user.setId(Integer.parseInt(fields[0]));	// Stores ID
				    user.setFirstName(fields[1]);				// Stores First Name
				    user.setLastName(fields[2]);				// Stores Last Name
				    user.setPhone(fields[3]);					// Stores Phone Number
				    user.setAccount(fields[4]);					// Stores Account number
				    user.setBalance(fields[5]);					// Stores Balance
				    user.setPassword(fields[6]);				// Stores PIN
				    users.add(user);							// Add new User object to Array users
				}
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return users;
	 }
	
	/**
	 * writeCsv		Write a CSV file with information stored in parameter accounts
	 * @param accounts	List of arrays with information of users
	 */
	 public void writeCsv(List<User> accounts) 
	 {
		  List<User> users = accounts;		// List of type User
		  
		  FileWriter fileWriter = null;
		  try 
		  {
			  fileWriter = new FileWriter(inputFile);
		   
			  fileWriter.append("ID,FIRST_NAME,LAST_NAME,CELLPHONE,ACCOUNT,BALANCE\n");
			  for(User u: users) 
			  {
				  fileWriter.append(String.valueOf(u.getId()));						// Append ID
				  fileWriter.append(",");											
				  fileWriter.append(u.getFirstName());								// Append First Name
				  fileWriter.append(",");
				  fileWriter.append(u.getLastName());								// Append Last Name
				  fileWriter.append(",");		
				  fileWriter.append(String.valueOf(u.getPhone()));					// Append Phone Number
				  fileWriter.append(",");
				  fileWriter.append(String.valueOf(u.getAccount()));				// Append Account Number
				  fileWriter.append(",");
				  fileWriter.append(String.valueOf(u.getBalance().getBalance()));	// Append Balance
				  fileWriter.append(",");
				  fileWriter.append(String.valueOf(u.getPassword()));				// Append PIN
				  fileWriter.append("\n");
			   }
		  } 
		  catch (Exception ex) 
		  {
			  ex.printStackTrace();  
		  } 
		  finally 
		  {
			  try 
			  {
				  fileWriter.flush();
				  fileWriter.close();
			  } 
			  catch (Exception e) 
			  {
				  e.printStackTrace();
			  }
		  }
	 }
}