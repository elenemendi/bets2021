package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import adapter.UserAdapter;
import businessLogic.BLFacade;
import domain.RegisteredUser;

public class BetTableGUI {
	static RegisteredUser user;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BetTableGUI window = new BetTableGUI(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param selectedUser 
	 */
	public BetTableGUI(RegisteredUser selectedUser) {
		this.user = selectedUser;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		
		BLFacade bl = MainGUI.getBusinessLogic();
		String nan = user.getidNumber();
		UserAdapter model = new UserAdapter(user);
		
		frame.setBounds(10,10,400,300);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(380,280));
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		
		
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
		
	}



}
