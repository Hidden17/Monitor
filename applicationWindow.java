import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class applicationWindow {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private static String localID = "8989";
	private static String localPW = "1234";
	static int wrongCounter = 0;
	static int remainingTries = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicationWindow window = new applicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public applicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1061, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel roomMenuPanel = new JPanel();
		roomMenuPanel.setBounds(0, 0, 1041, 622);
		frame.getContentPane().add(roomMenuPanel);
		roomMenuPanel.setLayout(null);
		
		JPanel roomOne = new JPanel();
		roomOne.setBounds(0, 0, 1041, 622);
		frame.getContentPane().add(roomOne);
		roomOne.setLayout(null);
		roomOne.setVisible(false);
		
		JButton btnRoomOne = new JButton("Room One");
		btnRoomOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomMenuPanel.setVisible(false);
				roomOne.setVisible(true);
			}
		});
		btnRoomOne.setBounds(135, 140, 97, 25);
		roomMenuPanel.add(btnRoomOne);
		
		JButton btnRoomTwo = new JButton("Room Two");
		btnRoomTwo.setBounds(135, 222, 97, 25);
		roomMenuPanel.add(btnRoomTwo);
		roomMenuPanel.setVisible(false);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 1041, 622);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		UsernameLabel.setBounds(213, 166, 121, 75);
		loginPanel.add(UsernameLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(213, 267, 108, 16);
		loginPanel.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(369, 195, 148, 22);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(369, 267, 148, 22);
		loginPanel.add(passwordField);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uName = usernameField.getText();
				String passW = passwordField.getText();
				
				if (uName.equals(localID) && passW.equals(localPW)) {
					JOptionPane.showMessageDialog( null,"correct");
					loginPanel.setVisible(false);
					roomMenuPanel.setVisible(true);
//					mainView frame = new mainView();
//					frame.setVisible(true);

				}
				else {
					  JOptionPane.showMessageDialog( null,"incorrect username or password, please try again " + "Remaining tries: " + --remainingTries);
					if (remainingTries == 0) {
						JOptionPane.showMessageDialog( null,"out of tries");
					}
				}
			}
		});
		btnEnter.setBounds(193, 379, 97, 25);
		loginPanel.add(btnEnter);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setBounds(374, 379, 97, 25);
		loginPanel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.exit(0);
			}
		});
		btnExit.setBounds(565, 379, 97, 25);
		loginPanel.add(btnExit);
		

	}
}
