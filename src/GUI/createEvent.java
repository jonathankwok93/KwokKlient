package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;

import Controller.Controller;


public class createEvent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public createEvent() {
		
		String[] months = {"Month", "January", "February", "March", "April", "May", "June", "July", "August",
			      "September", "October", "November", "December" };
		String[] day = {"Day", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", 
				"11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th", 
				"21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"};
		String[] hours = {"Hours", "1 hour", "2 hours", "3 hours", "4 hours",
				"5 hours", "6 hours", "7 hours", "8 hours", "9 hours", "10 hours", "11 hours", "12 hours",
				"13 hours", "14 hours", "15 hours", "16 hours", "17 hours", "18 hours", "19 hours", "20 hours",
				"21 hours", "22 hours", "23 hours", "24 hours"};
		String[] minutes = {"Minutes", "00 min", "10 min", "15 min", "20 min",
				"25 min", "30 min", "35 min", "40 min", "45"
						+ " min", "50 min", "55 min"};
		String[] repeat = {"Single event", "Yearly", "Monthly", "Weekly", "Daily"};
		
		String[] time = {"Time","00.00", "00:00", "00:30","01:00",
				"01:30","02:00","02:30",
				"03:00","03:30","04:00","04:30","05:00","06:00","06:30",
				"07:30","08:00","08:30","09:00","09:30",
				"10:00","10:30","11:00","11:30", "12:00"};
		String[] amPm = {"AM", "PM"};
		
		int nextYear = 1 +  Controller.getYear();
		int nextnextYear = 2 + Controller.getYear();
		int nextnextnextYear = 3 + Controller.getYear();
		
		String[] years = {Integer.toString(Controller.getYear()), Integer.toString(nextYear), Integer.toString(nextnextYear), Integer.toString(nextnextnextYear)};
		
		//String[] day = {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
		//		"17", "18", "19", "20", "21", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
 		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 750
				);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(36, 693, 117, 29);
		contentPane.add(btnCancel);
		
		JButton btnCreateEvent = new JButton("Create event");
		btnCreateEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.createEvent(4,4,4,4,2014,2014, "SP101", "Note");
				dispose();
			}
		});
		btnCreateEvent.setBounds(343, 693, 122, 29);
		contentPane.add(btnCreateEvent);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(36, 319, 61, 16);
		contentPane.add(lblStart);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(36, 390, 61, 16);
		contentPane.add(lblDuration);
		
		JLabel lblRepeat = new JLabel("Repeat");
		lblRepeat.setBounds(36, 429, 61, 16);
		contentPane.add(lblRepeat);
		
		JComboBox comboBox = new JComboBox(hours);
		comboBox.setBounds(109, 386, 102, 27);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(minutes);
		comboBox_1.setBounds(223, 386, 102, 27);
		contentPane.add(comboBox_1);
		
		JCheckBox chckbxFullDayEvent = new JCheckBox("All day event");
		chckbxFullDayEvent.setBounds(337, 315, 128, 23);
		contentPane.add(chckbxFullDayEvent);
		
		JComboBox comboBox_2 = new JComboBox(months);
		comboBox_2.setBounds(223, 343, 102, 27);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(day);
		comboBox_3.setBounds(109, 343, 102, 27);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(repeat);
		comboBox_4.setBounds(110, 425, 215, 27);
		contentPane.add(comboBox_4);
		
		JLabel lblCreateNewEvent = new JLabel("Create new event");
		lblCreateNewEvent.setFont(new Font("Helvetica", Font.PLAIN, 18));
		lblCreateNewEvent.setBounds(36, 60, 282, 29);
		contentPane.add(lblCreateNewEvent);
		
		JComboBox comboBox_5 = new JComboBox(time);
		comboBox_5.setBounds(109, 315, 102, 27);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox(amPm);
		comboBox_6.setBounds(223, 315, 102, 27);
		contentPane.add(comboBox_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(109, 536, 342, 107);
		contentPane.add(textArea);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(36, 536, 61, 16);
		contentPane.add(lblNotes);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(109, 464, 342, 56);
		contentPane.add(textArea_1);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(36, 464, 61, 16);
		contentPane.add(lblLocation);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(36, 101, 61, 16);
		contentPane.add(lblName);
		
		
		
		JLabel lblCBSCalendarLogo = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/cbs_calendar_logo.png")).getImage();
		//lblCBSCalendarLogo.setIcon(new ImageIcon(img));
		lblCBSCalendarLogo.setBounds(192, 17, 282, 66);
		contentPane.add(lblCBSCalendarLogo);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Entire DØK 13");
		chckbxNewCheckBox.setBounds(337, 469, 128, 23);
		contentPane.add(chckbxNewCheckBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 95, 342, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(36, 140, 38, 50);
		contentPane.add(lblDate);
		
		JComboBox comboBox_7 = new JComboBox(day);
		comboBox_7.setBounds(109, 153, 102, 27);
		contentPane.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox(months);
		comboBox_8.setBounds(223, 153, 102, 27);
		contentPane.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox(years);
		comboBox_9.setBounds(349, 153, 102, 27);
		contentPane.add(comboBox_9);
		
		

		
	}
}
