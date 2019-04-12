
/**
The Password class stores information about PIN.
*/

public class Password 
{
	private int pin;
	
	public Password(String pass)
	{
		pin = Integer.parseInt(pass);
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pass) {
		pin = pass;
	}
	public static boolean validPin (String pass)
	{
		boolean valid = true;
		int i = 0;
		if (pass.length()!=4)
			return !valid;
		while (valid && i < 4)
		{
			if (!Character.isDigit(pass.charAt(i)))
			{
				valid = false;
			}
			i++;
		}
		return valid;
	}
}
