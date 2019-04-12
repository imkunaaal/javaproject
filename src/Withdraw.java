import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class Withdraw extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static String text=" ";
ATM atm;
int value;
int valPhone ;
CsvFile file;
List<User> Accounts;

	public Withdraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 750, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(272, 210, 289, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(275, 270, 96, 60);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text=text.concat("1");
				textField.setText(text);
				
				
			}
		});
		panel.add(btnNewButton);
		
		JButton button = new JButton("2");
		button.setBounds(370, 270, 96, 60);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("2");
				textField.setText(text);
				
			}
		});
		
		JButton button_1 = new JButton("3");
		button_1.setBounds(465, 270, 96, 60);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("3");
				textField.setText(text);
				
			}
		});
		
		JButton button_2 = new JButton("5");
		button_2.setBounds(370, 330, 96, 60);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("5");
				textField.setText(text);
				
			}
		});
		panel.add(button_2);
		
		JButton button_3 = new JButton("4");
		
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						text=text.concat("4");
						textField.setText(text);
						
					}
				});
		
		button_3.setBounds(275, 330, 96, 60);
		panel.add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setBounds(465, 330, 96, 60);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("6");
				textField.setText(text);
				
			}
		});
		panel.add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.setBounds(275, 390, 96, 60);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("7");
				textField.setText(text);
				
			}
		});
		panel.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(370, 390, 96, 60);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("8");
				textField.setText(text);
				
			}
		});
		panel.add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setBounds(465, 390, 96,60);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("9");
				textField.setText(text);
				
			}
		});
		panel.add(button_7);
		
		JButton btnClear = new JButton("clear");
		btnClear.setBounds(275, 450, 96, 60);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				text="";
				
			}
		});
		
		JButton button_9 = new JButton("0");
		button_9.setBounds(370, 450, 96, 60);
		panel.add(button_9);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=text.concat("0");
				textField.setText(text);
				
			}
		});
		
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(465, 450, 96, 60);
		panel.add(btnAccept);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				try {
					atm=new ATM();
					file = new CsvFile ("ATMData.csv");
					 Accounts = file.readCsv();
					 String ss=Adapter.Phone_val.toString();
						valPhone = validatePhone(Accounts,ss);
				//		JOptionPane.showMessageDialog(null,Accounts.get(valPhone).getBalance().getBalance());
					 // Get a phone number from the user.
						value=Adapter.val;
						if(input.equalsIgnoreCase(""))
						{
							 JOptionPane.showMessageDialog(null, "Please enter the Amount");
						}
				 if (Double.parseDouble(input) <= Accounts.get(valPhone).getBalance().getBalance())
							 {
								 // Validate if input value is greater than zero
								 if (Double.parseDouble(input) > 0)
								 {
									 Accounts.get(valPhone).getBalance().withdraw(input);
									 file.writeCsv(Accounts);
									  
									 JOptionPane.showMessageDialog(null, "Take your money.");
									 
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
					
					 // Validate if phone number exists by validatePhone method
					 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 // Validate if user has sufficient funds
			
			
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter the amount");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(195, 100, 457, 100);
		panel.add(lblNewLabel_1);
		
		JButton button_8 = new JButton("< back");
		button_8.setBounds(0, 440, 96, 60);
		panel.add(button_8);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Menu menu=new Menu();
					setVisible(false);
					menu.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("image/BACK.jpeg"));
		lblNewLabel.setBounds(0, 0, 700, 900);
		panel.add(lblNewLabel);
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
