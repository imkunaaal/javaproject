/**
   The BankAccount class stores bank account balance.
*/
public class BankAccount
{
   private double balance;      // Account balance

   public BankAccount(String str)  {
	   balance = Double.parseDouble(str);
   }
   public void deposit(double amount) {
      balance += amount;
   }
   public void deposit(String str) {
      balance += Double.parseDouble(str);
   }
   public void withdraw(double amount) {
      balance -= amount;
   }
   public void withdraw(String str) {
      balance -= Double.parseDouble(str);
   }
   public void setBalance(double b) {
      balance = b;
   }
   public double getBalance() {
      return balance;
   }
}