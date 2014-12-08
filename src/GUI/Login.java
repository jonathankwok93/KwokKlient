package GUI;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import Controller.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JTextArea;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblpassword;
	private JButton btnRecoverPassword;
	private JTextArea textArea;


	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn = new JButton("Sign in");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			Controller logic = new Controller();
			
			if(logic.loginMessage(logic.login(textField.getText(), passwordField.getText()))){
				dispose();
			}
				
			}
		});
		btnLogIn.setBounds(477, 343, 117, 29);
		contentPane.add(btnLogIn);
		
		textField = new JTextField();
		textField.setBounds(437, 166, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(437, 206, 134, 28);
		contentPane.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(338, 170, 81, 21);
		contentPane.add(lblUsername);
		
		lblpassword = new JLabel("Password");
		lblpassword.setBounds(338, 210, 87, 21);
		contentPane.add(lblpassword);
		
		btnRecoverPassword = new JButton("Recover password");
		btnRecoverPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("http://imgur.com").toURI());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRecoverPassword.setBounds(6, 343, 146, 29);
		contentPane.add(btnRecoverPassword);
		
		try {
			textArea = new JTextArea(Controller.getQOTD());
			textArea.setLineWrap(true);
		} catch (Exception e1) {
			textArea.setText("error getting weather");
		}
		textArea.setBounds(6, 47, 588, 81);
		contentPane.add(textArea);
	}
}
