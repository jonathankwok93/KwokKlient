import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

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
	 * Create the frame.
	 */
	public weekView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 750);
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
		
		int SatDay = Logic.getFirstDayOfWeek() + 7;
		int SunDay = Logic.getFirstDayOfWeek() + 8;
		int MonDay = Logic.getFirstDayOfWeek() + 2;
		int TueDay = Logic.getFirstDayOfWeek() + 3;
		int WedDay = Logic.getFirstDayOfWeek() + 4;
		int ThuDay = Logic.getFirstDayOfWeek() + 5;
		int FriDay = Logic.getFirstDayOfWeek() + 6;

		
		btnExit.setBounds(664, 693, 180, 29);
		contentPane.add(btnExit);
		
		JLabel Monday = new JLabel("Mon " + MonDay);
		Monday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		Monday.setBounds(119, 68, 95, 39);
		contentPane.add(Monday);
		
		JLabel lblTuesday = new JLabel("Tue " + TueDay);
		lblTuesday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTuesday.setBounds(226, 68, 95, 39);
		contentPane.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wed " + WedDay);
		lblWednesday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblWednesday.setBounds(333, 68, 95, 39);
		contentPane.add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thu " + TueDay);
		lblThursday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblThursday.setBounds(440, 68, 95, 39);
		contentPane.add(lblThursday);
		
		JLabel lblFriday = new JLabel("Fri " + FriDay);
		lblFriday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFriday.setBounds(547, 68, 95, 39);
		contentPane.add(lblFriday);
		
		JLabel lblSaturday = new JLabel("Sat " + SatDay);
		lblSaturday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSaturday.setBounds(642, 68, 95, 39);
		contentPane.add(lblSaturday);
		
		JLabel lblFriday_1 = new JLabel("Sun " + SunDay);
		lblFriday_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFriday_1.setBounds(749, 68, 95, 39);
		contentPane.add(lblFriday_1);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTime.setBounds(20, 68, 60, 39);
		contentPane.add(lblTime);
		
	
		
		
		String[] columnNames = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		Object[][] data = {
			//	{"Time", "Mon " + MonDay, 
			//		"Tue " + TueDay, "Wed " + WedDay, 
			//		"Thu" + ThuDay, "Fri " + FriDay, "Sat " + SatDay, "Sun " + SunDay},
				{"06.00", null, null, null, null, null, null, null},
				{"07.00", null, null, null, null, null, null, null},
				{"08.00", null, null, null, null, null, null, null},
				{"09.00", null, null, null, null, null, null, null},
				{"10.00", null, null, null, null, null, null, null},
				{"11.00", null, null, null, null, null, null, null},
				{"12.00", null, null, null, null, null, null, null},
				{"13.00", null, null, null, null, null, null, null},
				{"14.00", null, null, null, null, null, null, null},
				{"15.00", null, null, null, null, null, null, null},
				{"16.00", null, null, null, null, null, null, null},
				{"17.00", null, null, null, null, null, null, null},
				{"18.00", null, null, null, null, null, null, null},
				{"19.00", null, null, null, null, null, null, null},
				{"20.00", null, null, null, null, null, null, null},
				{"21.00", null, null, null, null, null, null, null},
				{"22.00", null, null, null, null, null, null, null},
				{"23.00", null, null, null, null, null, null, null},
				{"24.00", null, null, null, null, null, null, null},
		};
		
		JTable table = new JTable(data, columnNames);
		table.setBounds(20, 105, 809, 576);
		contentPane.add(table);
		table.setRowHeight(30);
		table.setShowGrid(true);
		
		JLabel lblItIsCurrently = new JLabel("It is currently week " + Logic.getweekofyear());
		lblItIsCurrently.setBounds(20, 40, 215, 16);
		contentPane.add(lblItIsCurrently);
		//table.setFont(getFont().deriveFont(Font.BOLD));
	}
}
