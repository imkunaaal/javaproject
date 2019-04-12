import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountSetting extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public AccountSetting () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Background = new JLabel();
		Background.setIcon(new ImageIcon("image/AccountSetting.jpeg"));
	    Background.setBounds(0, 0,900, 750);
		panel.add(Background);
		setSize(900,750);
		setResizable(false);
        panel.add(Background);
		

        JButton btnNewButton = new JButton("Cancel");
		panel.add(btnNewButton);
	
		btnNewButton.setBounds(400,500, 140, 65);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Welcome card;
			
				 card= new Welcome();
				setVisible(false);
				card.setVisible(true);
			
				
			}
		});
	
		
		
	}
}

