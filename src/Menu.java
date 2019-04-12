import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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

public class Menu extends Adapter{

	private JPanel contentPane;
	 List<User> Accounts;
	 JLabel lblSecurity;
	String greet;
 ATM atm;
 Long value;
	
	public Menu() throws IOException {
		

		Adapter adp=new Adapter();
		value=adp.getPhone_val();
	atm=new ATM();
	 CsvFile file = new CsvFile ("ATMData.csv");
	 Accounts = file.readCsv();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 750, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton withdraw_btn = new JButton("WITHDRAW");
		withdraw_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Withdraw draw=new Withdraw();
			setVisible(false);
			draw.setVisible(true);
			}
		});
		withdraw_btn.setBounds(0, 250, 230, 60);
		panel.add(withdraw_btn);
		
		JButton button = new JButton("DEPOSITE");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	String input = JOptionPane.showInputDialog("Amount of money to deposit:");
				DepositeMoney dr=new DepositeMoney();
				setVisible(false);
				dr.setVisible(true);
			}
		});
		button.setBounds(0, 350, 230, 60);
		panel.add(button);
		
		JButton transfer_btn = new JButton("TRANSFER");
		transfer_btn.setBounds(0, 440, 230, 60);
		transfer_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Transfer transfer;
			try {
				transfer = new Transfer();
				setVisible(false);
				transfer.setVisible(true);
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
	
			}
		});
		panel.add(transfer_btn);
		
		
        lblSecurity = new JLabel("Welcome " + Accounts.get(Adapter.val).getFirstName());
		lblSecurity.setForeground(Color.WHITE);
		lblSecurity.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		lblSecurity.setBounds(210, 70, 500, 200);
		panel.add(lblSecurity);
		
		
		JButton pin_btn = new JButton("CHANGE PIN");
		pin_btn.setBounds(482, 250, 230, 60);
		pin_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		changePin change= new changePin();
			
		setVisible(false);
			change.setVisible(true);
			
		}
	});
		panel.add(pin_btn);
		
		JButton balance_btn = new JButton("BALANCE ");
		balance_btn.setBounds(482, 350, 230, 60);
		balance_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			Balance balance= new Balance();
				
			setVisible(false);
			balance.setVisible(true);
				
				
			}
		});
		panel.add(balance_btn);
		
		JButton button_4 = new JButton("ACCOUNT SETTING");
		button_4.setBounds(482, 440, 230, 60);
		
		panel.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			AccountSetting St= new AccountSetting();
				
			setVisible(false);
			St.setVisible(true);
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("image/BACK.jpeg"));
		lblNewLabel.setBounds(0, 0, 684, 900);
		panel.add(lblNewLabel);
		setSize(700,900);
		setResizable(false);
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


