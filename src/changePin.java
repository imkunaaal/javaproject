import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

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

public class changePin extends JFrame {

	private JPanel contentPane;
	
	private JPasswordField new_Pin;
	private JPasswordField reEnter_pin;

	ATM atm;
	Menu menu;
	int value;
	int valPhone ;
	CsvFile file;
	List<User> Accounts;
	String input;
	
	public changePin() {
		try {
			file = new CsvFile ("ATMData.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Accounts = file.readCsv();

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0, 700, 900);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
		
		JLabel sendTo = new JLabel("Change PIN");
		sendTo.setHorizontalAlignment(SwingConstants.CENTER);
		sendTo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		sendTo.setForeground(Color.WHITE);
		sendTo.setBounds(196, 87, 263, 37);
		panel.add(sendTo);
		
		
		
	
		
		JLabel IFSC = new JLabel("Enter New PIN");
		IFSC.setHorizontalAlignment(SwingConstants.CENTER);
		IFSC.setForeground(Color.WHITE);
		IFSC.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		IFSC.setBounds(133, 209, 205, 37);
		panel.add(IFSC);
		
		new_Pin = new JPasswordField();
		new_Pin.setColumns(10);
		new_Pin.setBounds(369, 216, 182, 37);
		panel.add(new_Pin);
		
		JLabel lblSecurity = new JLabel("Re-Enter PIN");
		lblSecurity.setForeground(Color.WHITE);
		lblSecurity.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		lblSecurity.setBounds(138, 265, 200, 51);
		panel.add(lblSecurity);
		
		reEnter_pin = new JPasswordField();
		reEnter_pin.setColumns(10);
		reEnter_pin.setBounds(369, 278, 182, 37);
		panel.add(reEnter_pin);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reEnter_pin.setText("");
				new_Pin.setText("");
				
			}
		});
		cancel_btn.setBounds(600, 450, 150, 70);
		panel.add(cancel_btn);
		
		JButton back_btn = new JButton("< Back");
		back_btn.setBounds(0, 372, 150, 70);
		back_btn.addActionListener(new ActionListener() {
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
		panel.add(back_btn);
		
		JButton proceed_btn = new JButton("Proceed");
		proceed_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				input=String.valueOf(new_Pin.getPassword());
				 //Validate if PIN inserted is valid and is different from current user PIN
				 if (Password.validPin(input) && Integer.parseInt(input)!=Accounts.get(Adapter.val).getPassword())
				 {
					String input2 = String.valueOf(reEnter_pin.getPassword());
					 // Validate if PINs match
					 if (input.equals(input2))
					 {
						Accounts.get(Adapter.val).setPassword(input2);
						file.writeCsv(Accounts);
						 JOptionPane.showMessageDialog(null, "PIN changed.");
						

						 Thank_You th=new Thank_You();
						 setVisible(false);
						 th.setVisible(true);
						 
						
					 System.out.println("New PIN: " + atm.Accounts.get(Adapter.val).getPassword());
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "PINs don't match. Try later"); 
					 }
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null, "Invalid PIN.");
				 }
				;
			}
		});
		proceed_btn.setBounds(600, 370, 150, 70);
		panel.add(proceed_btn);
		
		
		JLabel back = new JLabel("New label");
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		back.setIcon(new ImageIcon("image/BACK.jpeg"));
		back.setBounds(0, 0, 700, 900);
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
