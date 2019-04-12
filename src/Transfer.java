import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Transfer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField account;
	private JTextField amount_txt;
	ATM atm;
	Menu menu;
	int value;
	int valPhone ;
	CsvFile file;
	List<User> Accounts;
	String input;
	public Transfer() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,900);
		contentPane = new JPanel();
		
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel sendTo = new JLabel("Insert phone number of beneficiary: ");
		sendTo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		sendTo.setForeground(Color.WHITE);
		sendTo.setBounds(56, 140, 600, 37);
		panel.add(sendTo);
		
		JLabel account_holder = new JLabel("Enter");
		account_holder.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 23));
		account_holder.setForeground(Color.WHITE);
		account_holder.setBounds(180, 220, 251, 45);
		panel.add(account_holder);
		
		textField = new JTextField();
		textField.setBounds(369, 220, 182, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel IFSC = new JLabel("Enter again");
		IFSC.setHorizontalAlignment(SwingConstants.CENTER);
		IFSC.setForeground(Color.WHITE);
		IFSC.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		IFSC.setBounds(180, 270, 182, 45);
		panel.add(IFSC);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(369, 270, 182, 45);
		panel.add(account);
		
		JLabel lblSecurity = new JLabel("Amount");
		lblSecurity.setForeground(Color.WHITE);
		lblSecurity.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		lblSecurity.setBounds(180, 320, 142, 51);
		panel.add(lblSecurity);
		
		amount_txt = new JTextField();
		amount_txt.setColumns(10);
		amount_txt.setBounds(369, 320, 182, 45);
		panel.add(amount_txt);
	
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					menu = new Menu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				menu.setVisible(true);
			}
		});
		cancel_btn.setBounds(600, 450, 150, 70);
		panel.add(cancel_btn);
		
		JButton back_btn = new JButton("< Back");
		back_btn.setBounds(0, 372, 150, 70);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					menu = new Menu();
					setVisible(false);
					menu.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					setVisible(false);
					menu.setVisible(true);
				}
				
			}
		});
		
		panel.add(back_btn);
		
		file = new CsvFile ("ATMData.csv");
		 Accounts = file.readCsv();
	
		JButton proceed_btn = new JButton("Proceed");
		proceed_btn.setBounds(600, 370, 150, 70);
		proceed_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Ask for beneficiary phone number
				 input = textField.getText();
				 // Validate if phone number exists
		int		 valPhone2 = validatePhone(Accounts, input);
				 // Validate if beneficiary phone number is different than current user phone number 
			
		if (valPhone2 >= 0 && valPhone!=valPhone2)
				 {
					 // Ask for beneficiary phone number again 
			String		 input2 = account.getText();
					 // Validate if beneficiary phone numbers match 
					 if (input.equals(input2))
					 {
						 String in=amount_txt.getText();
						 // Validate if current user has sufficient funds
						 if (Double.parseDouble(in) <= Accounts.get(valPhone).getBalance().getBalance())
						 {
							 // Validate if amount of money is greater than zero
							 if (Double.parseDouble(in) > 0)
							 {
								 Accounts.get(Adapter.val).getBalance().withdraw(in);	// Withdraw amount of money from user account
								 Accounts.get(valPhone2).getBalance().deposit(in);	// Deposit amount of money in beneficiary account
								 JOptionPane.showMessageDialog(null, "Successful transfer.");
								 
								 
								 file.writeCsv(Accounts);
								 System.out.printf("New balance %d: $%f\nNew balance %d: $%f\n",
										 Accounts.get(Adapter.val).getPhone(),
										 Accounts.get(Adapter.val).getBalance().getBalance(),
										 Accounts.get(valPhone2).getPhone(),
										 Accounts.get(valPhone2).getBalance().getBalance());
								 

								 Thank_You th=new Thank_You();
								 setVisible(false);
								 th.setVisible(true);
								 
							 }
							 else
								 JOptionPane.showMessageDialog(null, "Amount of money must be more than 0");
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(null, "Insufficient funds");
						 }
					 }
					 else
						 JOptionPane.showMessageDialog(null, "Phone numbers don't match. Try later.");
				 }
				 else
					 JOptionPane.showMessageDialog(null, "Invalid phone number.");
			}
		});
		panel.add(proceed_btn);
		
		JLabel back = new JLabel("New label");
		back.setForeground(Color.WHITE);
		back.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		back.setIcon(new ImageIcon("image/BACK.jpeg"));
		back.setBounds(0, 0, 750, 900);
		panel.add(back);
	}
	 public static int validatePhone (List<User> accounts, String input)
	 {
		 int phoneFound = -1;	// Index of phone number if it's found. 
		 // Validate if there're letters in phone number
		 char[] arrayChar = input.toCharArray();
		 for (char c : arrayChar)
		 {
			 if (Character.isLetter(c))
				 return phoneFound;
		 }
		 // Look for index of phone number in account List.
		 long phone = Long.parseLong(input);
		 
		 for (int index = 0; index < accounts.size(); index++)
		 {
			 if (accounts.get(index).getPhone() == phone)
			 {
				 System.out.println("Phone has been found !");
				 phoneFound = index;
			 }
		 }
		return phoneFound;
	 }
}
