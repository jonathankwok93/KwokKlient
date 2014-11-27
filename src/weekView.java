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
	
	int today = Logic.getdayofmonth();
	int offset =  0;
	
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
		
		
		int SatDay = today + 7 + offset;
		int SunDay = today + 8 + offset;
		final int MonDay = today + 2 + offset;
		int TueDay = today + 3 + offset;
		int WedDay = today + 4 + offset;
		int ThuDay = today + 5 + offset;
		int FriDay = today + 6 + offset;

		
		btnExit.setBounds(664, 693, 180, 29);
		contentPane.add(btnExit);
		
		final JLabel Monday = new JLabel("Mon " + MonDay);
		Monday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		Monday.setBounds(119, 68, 95, 39);
		contentPane.add(Monday);
		
		final JLabel lblTuesday = new JLabel("Tue " + TueDay);
		lblTuesday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTuesday.setBounds(226, 68, 95, 39);
		contentPane.add(lblTuesday);
		
		final JLabel lblWednesday = new JLabel("Wed " + WedDay);
		lblWednesday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblWednesday.setBounds(333, 68, 95, 39);
		contentPane.add(lblWednesday);
		
		final JLabel lblThursday = new JLabel("Thu " + TueDay);
		lblThursday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblThursday.setBounds(440, 68, 95, 39);
		contentPane.add(lblThursday);
		
		final JLabel lblFriday = new JLabel("Fri " + FriDay);
		lblFriday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFriday.setBounds(547, 68, 95, 39);
		contentPane.add(lblFriday);
		
		final JLabel lblSaturday = new JLabel("Sat " + SatDay);
		lblSaturday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSaturday.setBounds(642, 68, 95, 39);
		contentPane.add(lblSaturday);
		
		final JLabel lblSunday = new JLabel("Sun " + SunDay);
		lblSunday.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSunday.setBounds(749, 68, 95, 39);
		contentPane.add(lblSunday);
		
		final JLabel lblTime = new JLabel("Time");
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
		
		JButton btnToday = new JButton("Today");
		btnToday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			offset = 0;
			}
		});
		btnToday.setBounds(655, 27, 117, 29);
		contentPane.add(btnToday);
		
		JButton button = new JButton("<");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Days.setOffSetMinus(1);
			Monday.setText(Days.getMonDay());
			lblTuesday.setText(Days.getTueDay());
			lblWednesday.setText(Days.getWedDay());
			lblThursday.setText(Days.getThuDay());
			lblFriday.setText(Days.getFriDay());
			lblSaturday.setText(Days.getSatDay());
			lblSunday.setText(Days.getSunDay());			}
		});
		button.setBounds(597, 27, 45, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton(">");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Days.setOffSetPlus(1);
			Monday.setText(Days.getMonDay());
			lblTuesday.setText(Days.getTueDay());
			lblWednesday.setText(Days.getWedDay());
			lblThursday.setText(Days.getThuDay());
			lblFriday.setText(Days.getFriDay());
			lblSaturday.setText(Days.getSatDay());
			lblSunday.setText(Days.getSunDay());
			}
		});
		button_1.setBounds(784, 27, 45, 29);
		contentPane.add(button_1);
		//table.setFont(getFont().deriveFont(Font.BOLD));
	}
}

class Days{
	static int today = Logic.getdayofmonth();
	static int offset = 0;
	static int SatDay = today + 7 + offset;
	static int SunDay = today + 8 + offset;
	static int MonDay = today + 2 + offset;
	static int TueDay = today + 3 + offset;
	static int WedDay = today + 4 + offset;
	static int ThuDay = today + 5 + offset;
	static int FriDay = today + 6 + offset;
	
	public int getOffset() {
		return offset;
	}
	public static void setOffset(int off) {
		offset += off;
		MonDay += off;
		TueDay += off;
		WedDay += off;
		FriDay += off;
		SatDay += off;
		SunDay += off;			
	}
	

	public static String getSatDay() {
		return String.valueOf(SatDay);
	}
	
	public static void setOffSetMinus(int off){
		MonDay -= off;
		TueDay -= off;
		WedDay -= off;
		ThuDay -= off;
		FriDay -= off;
		SatDay -= off;
		SunDay -= off;
	}
	
	public static void setOffSetPlus(int off){
		MonDay += off;
		TueDay += off;
		WedDay += off;
		ThuDay += off;
		FriDay += off;
		SatDay += off;
		SunDay += off;
	}
	
	public static void setSatDay(int offset) {
		SatDay += offset;
	}
	public static String getSunDay() {
		return String.valueOf(SunDay);
	}
	public void setSunDay(int offset) {
		SunDay += offset;
	}
	public static String getTueDay() {
		return String.valueOf(TueDay);
	}
	public void setTueDay(int offset) {
		TueDay += offset;
	}
	public static  String getWedDay() {
		return String.valueOf(WedDay);
	}
	public void setWedDay(int offset) {
		WedDay += offset;
	}
	public static String getThuDay() {
		return String.valueOf(ThuDay);
	}
	public void setThuDay(int offset) {
		ThuDay = offset;
	}
	public static String getFriDay() {
		return String.valueOf(FriDay);
	}
	public void setFriDay(int offset) {
		FriDay += offset;
	}
	public static String getMonDay() {
		return String.valueOf(MonDay);
		
	}
	
	
}