import javax.swing.JFrame;

/**
   The User class stores information of users.
*/
public class User extends JFrame
{
	private int userId;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private long accountNumber;
	private BankAccount balance;
	private Password pin;
 
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		userId = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fname) {
		firstName = fname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lname) {
		lastName = lname;
	}
	public Long getPhone() {
		return phoneNumber;
	}
	public void setPhone(String phone) {
		phoneNumber = Long.parseLong(phone);
	}
	public long getAccount() {
		return accountNumber;
	}
	public void setAccount(String account) {
		accountNumber = Long.parseLong(account);
	}
	public BankAccount getBalance() {
		return balance;
	}
	public void setBalance(String bal) {
		balance = new BankAccount(bal);
	}
	public void setPassword(String pass) {
		pin = new Password(pass);
	}
	public int getPassword() {
		return pin.getPin();
	} 
	public String toString()
	{
		String info = String.format("UserId = %d \nFirst Name = %s \nLast Name = %s\n"
		   		+ "Phone = %d \nAccount Number = %d \nBalance = %.2f \nPin = %d\n", 
	    		userId, firstName, lastName, phoneNumber, accountNumber, balance.getBalance(),
	    		pin.getPin());
		return info;
	}

}
