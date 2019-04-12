
import java.text.NumberFormat; // Helps with formatting doubles as currency
import java.util.Scanner; // Will be used to get input from the user

public class ATM {
	
	public static void main(String[] args) {
	
		// Create and instantiate two Account objects

		Account checking = new Account();
		checking.setType("Checking");
		checking.setBalance(0.00);
		checking.setRate(0.00);

		Account savings = new Account();
		savings.setType("Savings");
		savings.setBalance(0.00);
		savings.setRate(2.00);

		NumberFormat formatter = NumberFormat.getCurrencyInstance(); // Creates the formatter object for currency
		Scanner sc = new Scanner(System.in); // Creates the sc object to read user input

		boolean session = true; // This variable will break the (while) loop when false

		while (session) {

			// Present the user with a menu of 5 options

			System.out.print("\nATM Menu: \n \n"
							 + "1. Deposit Money \n"
							 + "2. Withdraw Money \n"
							 + "3. Transfer Funds \n"
							 + "4. Check Account Balance\n"
							 + "5. End Session\n \n"
							 + "Enter selection: ");

			int selection = sc.nextInt(); // assign the user's input to the selection variable

			// This switch block will handle one of five selections and deal with them appropriately

			switch (selection) {

				// case 1 handles the depositing of money

				case 1:
					System.out.print("Enter (1) for Savings or (2) for Checking: ");
					int depAccount = sc.nextInt(); // Keeps track of which account to deposit money to

					if (depAccount == 1) {

						System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

						System.out.println("How much money would you like to deposit?");
						double deposit = sc.nextDouble();

						savings.deposit(deposit);

						System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
						

					}

					else if (depAccount == 2) {
						
						System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

						System.out.println("How much money would you like to deposit?");
						double deposit = sc.nextDouble();

						checking.deposit(deposit);

						System.out.println("\nChecking balance is now: " + formatter.format(checking.getBalance()) + "\n");

					}

					break;

				

				// case 2 handles the withdrawal of money	

				case 2:
					System.out.print("\nEnter (1) for Savings or (2) for Checking: ");
					int witAccount = sc.nextInt(); // Keeps track of which account to withdraw from

					if (witAccount == 1) {

						System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

						System.out.println("How much money would you like to withdraw?");
						double withdraw = sc.nextDouble();

						savings.withdraw(withdraw);

						System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
						

					}

					else if (witAccount == 2) {
						
						System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

						System.out.println("How much money would you like to withdraw?");
						double withdraw = sc.nextDouble();

						checking.withdraw(withdraw);

						System.out.println("\nYour Checking balance is now: " + formatter.format(checking.getBalance()) + "\n");

					}

					break;

				// case 3 handles the transfer of funds	

				case 3:
					System.out.print("\nFrom which account do you wish to transfer funds from?, (1) for Savings or (2) for Checking: ");
					int tranAccount = sc.nextInt();

					if (tranAccount == 1) {

						System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

						System.out.print("How much money do you wish to transfer from Savings to Checking?: ");
						double tranAmount = sc.nextDouble();

						savings.withdraw(tranAmount);
						checking.deposit(tranAmount);

						System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Savings to Checking");

						System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
						System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");

					}

					else if (tranAccount == 2) {

						System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

						System.out.print("How much money do you wish to transfer from Checking to Saving?: ");
						double tranAmount = sc.nextDouble();

						checking.withdraw(tranAmount);
						savings.deposit(tranAmount);

						System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Checking to Savings");

						System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
						System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
						
					}

					break;
					
				// case 4 simply outputs the balances of both Checking and Savings accounts	
				
				case 4:
					System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
					System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
					
					break;

				// case 5 breaks out of the (while) loop when the user is finished using the ATM

				case 5:
					session = false;
					
					break;

			}				 	
			

		}

		System.out.println("\nThank you for banking with us!\n");

	}

}


class Account {

	// Here we declare some variables that a typical bank account will have

	String type;
	double balance;
	double rate;

	// The following methods are a combination of getter/setter methods as well
	// as two special deposit() and withdraw() methods

	void setType(String accType) {
		
		type = accType;
	}

	void setBalance(double accBal) {
		
		balance = accBal;
	}

	void setRate(double accRate) {
		
		rate = accRate;
	}

	void deposit(double dep) {
		
		balance += dep; // Take the Account object's balance and add to it the current deposit
	}

	void withdraw(double wit) {
		
		balance -= wit; // Take the Account object's balance and subtract from it the current withdrawal
	}


	String getType() {
		
		return type;
	}

	double getBalance() {
		
		return balance;
	}

	double getRate() {
		
		return rate;
	}

}