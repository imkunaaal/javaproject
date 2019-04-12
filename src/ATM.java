import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ATM extends Adapter
{
	 CsvFile file;
		 List<User> Accounts;		// List of Accounts returned by method 'file.readCsv'
		 String input;				// Stores input from dialog box
		 String input2;				// Stores input from dialog box
	public	 String greeting;			// Greeting message
		 String showbalance;		// Show balance message
		 int pin; 					// Pin typed by user
		 int valPhone; 				// Index of phone number in List Accounts
		 int valPhone2; 			// Index of phone number in List Accounts
		 Menu menu;
		 int service;				// Option of service
		 int attempts=1;			// Number of attempts when user insert PIN

		 private JPasswordField pin_text;
		 private JPanel contentPane;
			private JTextField card_number;
			JButton go_btn;
			
			 ATM() throws IOException  {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0,0, 750, 900);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				JPanel panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				
				JButton btnNewButton = new JButton("Reset");
				btnNewButton.setBounds(200, 400, 170, 65);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pin_text.setText("");
						card_number.setText("");
					}
				});
				panel.add(btnNewButton);
				
				JButton go_btn = new JButton("Proceed");
				 go_btn.setBounds(400, 400,170, 65);
				
				panel.add( go_btn);
				
				JLabel label = new JLabel("Phone Number");
				label.setHorizontalAlignment(SwingConstants.LEFT);
				label.setBackground(Color.WHITE);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 22));
				label.setBounds(100, 200, 146, 49);
				panel.add(label);
				
				
				
				JLabel lblPin = new JLabel("PIN ");
				lblPin.setHorizontalAlignment(SwingConstants.LEFT);
				lblPin.setForeground(Color.WHITE);
				lblPin.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 22));
				lblPin.setBackground(Color.WHITE);
				lblPin.setBounds(100, 250, 136, 49);
				panel.add(lblPin);
				

				pin_text = new JPasswordField();
				pin_text.setColumns(10);
				pin_text.setBounds(335, 250, 243, 37);   
			
				
				panel.add(pin_text);
				
				card_number = new JTextField();
				card_number.setBounds(335, 200, 243, 37);
				panel.add(card_number);
				
				JLabel back = new JLabel("");
				back.setHorizontalAlignment(SwingConstants.LEFT);
				back.setBackground(Color.WHITE);
				back.setLocation(0, 0);
				back.setSize(900,700);
				back.setIcon(new ImageIcon("image/BACK.jpeg"));
				panel.add(back);
				
				
				go_btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						 try {
							file = new CsvFile ("ATMData.csv");
							 Accounts = file.readCsv();
							 
							 try {
							     Long   x = Long.parseLong(card_number.getText());
							     
							     if(card_number.getText().equals("")) {
									 JOptionPane.showMessageDialog(null, "Please enter Phone Number");
								    }
							     
							    } catch (NumberFormatException nfe) {
							    	 JOptionPane.showMessageDialog(null, "Please enter digits Phone Number");
							        
							    }
							

							
							 String in=String.valueOf(pin_text.getPassword());
							 
							 try {
							     int  x =Integer.parseInt(in) ;
							     
							     if(x>999) {
							    	 JOptionPane.showMessageDialog(null, "Please enter 4 Digit PIN");
							     }
							    } catch (NumberFormatException nfe) {
							    	 JOptionPane.showMessageDialog(null, "Please enter digits Phone Number");
							        card_number.setText("");
							        pin_text.setText("");
							        
							    }
if(in.equals(""))
{
	 JOptionPane.showMessageDialog(null, "Please enter PIN Number");
}
							 // Get a phone number from the user.
							 input = card_number.getText();
							 // Validate if phone number exists by validatePhone method
							Adapter.val = validatePhone(Accounts, input);
							 // Validate if valPhone is greater than 0
							
							
							
							
							
							 
							 if (Adapter.val >= 0)
							 {
								 // Show information about user
								 System.out.println("\n" + Accounts.get(Adapter.val));
								 // Process will be closed if exceeds 3 attempts
								 while (attempts<4)
								 {
									 System.out.println("Attempts " + attempts);
								 
									 
									 // Read PIN from dialog box
								
									 String input2=String.valueOf(pin_text.getPassword());
									 pin = Integer.parseInt(input2);
									 // Validate if PIN inserted is equal to PIN of user
									 if (Accounts.get(Adapter.val).getPassword() == pin)
									 {
										
										Adapter.Phone_val=Long.parseLong(input);
										
											menu = new Menu();
											
											
											 setVisible(false);
											 menu.setVisible(true);
											 attempts = 4;
									 }
									 else
									 {
										 if (attempts > 2)
										 {
											 JOptionPane.showMessageDialog(null,"Attempts exceeded. Contact for assistance.");
											 System.exit(0);
											 attempts++;
										 }
										 else
										 {
											 JOptionPane.showMessageDialog(null,"Incorrect PIN. Please try again.");
											 pin_text.setText("");
											 attempts++;
											 
										 }
									 }
								 }
							 }
							 else
							 {
								 JOptionPane.showMessageDialog(null,"Phone has not been found. "
									 		+ "Please verify your phone number or call for assistance.");
							 }
								 
								 }
							 
							 
						 
										
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
							
					
									
									 
									 greeting = String.format("Welcome %s", Accounts.get(valPhone).getFirstName()); // Welcome message  
								
								
					 /**
					  * @param 	accounts 	ArrayList of accounts
					  * @param 	phon		Phone number
					  * @return	Return 		index of phone number in accounts ArrayList
					  */
			
					}
				
			

				});
			
				
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
		
				
					
				
		

