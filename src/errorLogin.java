import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.*;


public class errorLogin extends JFrame {

	/**
	 * Create the panel.
	 */
	public errorLogin() {
		getContentPane().setLayout(null);
		
		JButton btnRetry = new JButton("Retry");
		btnRetry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogonScreen logon = new LogonScreen();
				logon.setVisible(true);
				dispose();
			}
		});
		btnRetry.setBounds(42, 200, 180, 29);
		getContentPane().add(btnRetry);
		
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
		
		btnRecoverPassword.setBounds(232, 193, 178, 29);
		getContentPane().add(btnRecoverPassword);
		
		JLabel lblYourUserCredentials = new JLabel("Your user credentials are incorrect");
		lblYourUserCredentials.setBounds(128, 116, 368, 16);
		getContentPane().add(lblYourUserCredentials);
		
		JButton btnExit = new JButton("Exit ");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			System.exit(0);
			}
		});
		btnExit.setBounds(327, 243, 117, 29);
		getContentPane().add(btnExit);

	}
}
