package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.image.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import Controller.Controller;


public class LogonScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	public LogonScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    setResizable(false);

		JLabel lblWelcomeToThe = new JLabel("Welcome to CBS calendar!");
		lblWelcomeToThe.setBounds(35, 23, 255, 16);
		contentPane.add(lblWelcomeToThe);

		JLabel lblLogOnWith = new JLabel("Sign in with your LEARN"
				+ " account to proceed...");
		lblLogOnWith.setBounds(35, 43, 369, 16);
		contentPane.add(lblLogOnWith);

		textField = new JTextField();
		textField.setBounds(344, 118, 184, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		final JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(271, 124, 72, 16);
		contentPane.add(lblUsername);

		final JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(271, 153, 61, 16);
		contentPane.add(lblPassword);

		JButton btnLogOn = new JButton("Sign in");
		btnLogOn.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				//Open CalendarScreen??

				Controller logic = new Controller();
				if(logic.loginMessage(logic.login(textField.getText(), passwordField.getText()))){
					dispose();
				}
			}

		});

		btnLogOn.setBounds(380, 187, 148, 29);
		contentPane.add(btnLogOn);

		passwordField = new JPasswordField();
		passwordField.setBounds(344, 147, 184, 28);
		contentPane.add(passwordField);

		JLabel iconLabel = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/cbs_logo_horizontal.png")).getImage();
		//iconLabel.setIcon(new ImageIcon(img));
		iconLabel.setBounds(25, 71, 235, 210);
		contentPane.add(iconLabel);

		JButton btnRecoverPassword = new JButton("Recover password");
		btnRecoverPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String URL = "https://help.cbs.dk/recoverpw.asp"; 
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRecoverPassword.setBounds(396, 293, 148, 29);
		contentPane.add(btnRecoverPassword);

		JRadioButton rdbtnRememberMe = new JRadioButton("Remember me!");
		rdbtnRememberMe.setBounds(387, 215, 141, 23);
		contentPane.add(rdbtnRememberMe);

		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(18, 293, 117, 29);
		contentPane.add(btnExit);

//		ImageIcon cbsLogo = new ImageIcon(getClass().getResource("/cbsLogo.jpg"));
//		JLabel lblNewLabel = new JLabel(cbsLogo);
//		lblNewLabel.setBounds(47, 124, 61, 16);
//		contentPane.add(lblNewLabel);
	}

	class getTextField{

		public JTextField getUsernameTextfield() {
			return textField;
		}
		public JPasswordField getPasswordTextField() {
			return passwordField;
		}
	}
}