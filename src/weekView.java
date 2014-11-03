import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;


public class weekView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					weekView frame = new weekView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public weekView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit Week View");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(637, 491, 180, 29);
		contentPane.add(btnExit);
		
		JLabel Monday = new JLabel("Monday");
		Monday.setBounds(119, 68, 95, 39);
		contentPane.add(Monday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBounds(226, 68, 95, 39);
		contentPane.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setBounds(333, 68, 95, 39);
		contentPane.add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setBounds(440, 68, 95, 39);
		contentPane.add(lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setBounds(547, 68, 95, 39);
		contentPane.add(lblFriday);
		
		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setBounds(642, 68, 95, 39);
		contentPane.add(lblSaturday);
		
		JLabel lblFriday_1 = new JLabel("Sunday");
		lblFriday_1.setBounds(749, 68, 95, 39);
		contentPane.add(lblFriday_1);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(10, 68, 60, 39);
		contentPane.add(lblTime);
		
		
		String[] columnNames = {"Time", "Monday"};
		Object[][] data = {
				{"08.00", "a"},
				{"09.00", "b"},
				{"10.00", "c"},
				{"11.00", "d"},
				{"12.00", "e"},
				{"13.00", "f"},
				{"14.00", "g"},
		};
		
		JTable table = new JTable(data, columnNames);
		table.setBounds(20, 119, 100, 214);
		contentPane.add(table);
//		JTable(Object[][] rowData, Object[] columnNames);
	}
}
