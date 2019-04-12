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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Balance extends JFrame {

	private JPanel contentPane;
	ATM atm;
	Menu menu;
	int value;
	int valPhone ;
	CsvFile file;
	List<User> Accounts;
	String input;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Balance() {
		
		try {
			file = new CsvFile ("ATMData.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Accounts = file.readCsv();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,900);
		contentPane = new JPanel();
		
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel old_Pin = new JLabel("Holder Name ");
		old_Pin.setHorizontalAlignment(SwingConstants.CENTER);
		old_Pin.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 23));
		old_Pin.setForeground(Color.WHITE);
		old_Pin.setBounds(86, 250, 252, 45);
		panel.add(old_Pin);
		
		
		JLabel lblSecurity = new JLabel("Current Balance");
		lblSecurity.setForeground(Color.WHITE);
		lblSecurity.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		lblSecurity.setBounds(86, 358, 242, 51);
		panel.add(lblSecurity);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.addActionListener(new ActionListener() {
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
		proceed_btn.setBounds(600, 370, 150, 70);
		proceed_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Thank_You th=new Thank_You();
					setVisible(false);
					th.setVisible(true);
				
			}
		});
		panel.add(proceed_btn);
		
		JTextArea holder_name = new JTextArea();
		holder_name.setBounds(348, 257, 205, 37);
		panel.add(holder_name);
		holder_name.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		holder_name.setText(Accounts.get(Adapter.val).getFirstName());
		
		
		
		JTextArea balance_txt = new JTextArea();
		balance_txt.setBounds(348, 362, 205, 37);
		balance_txt.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		panel.add(balance_txt);
		
		String SS=Double.toString(Accounts.get(Adapter.val).getBalance().getBalance());
		balance_txt.setText(SS);
		
		
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
