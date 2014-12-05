package GUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import Controller.Controller;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Font;

public class Calendar extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String[] years = {"2014","2015", "2016", "2017", "2018", "2019", "2020" };
  String[] viewMode = {"Month view", "Agenda view", "Week view"};

  @SuppressWarnings("unchecked")
JComboBox comboBox = new JComboBox(years);

  String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
      "September", "October", "November", "December" };

  CalendarModel model = new CalendarModel();
  JTable agendaTable1= new JTable(model);


  public Calendar() {
    super();
    comboBox.setBounds(218, 5, 82, 30);
    comboBox.setSelectedIndex(0);
  //  comboBox.addItemListener(new ItemListener());
    getContentPane().setLayout(null);
    getContentPane().add(comboBox);
    setResizable(false);
    
    JButton btnToday = new JButton("Today");
    btnToday.setBounds(370, 6, 100, 29);
    btnToday.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    }
    });
    getContentPane().add(btnToday);
    
    JButton btnSignout = new JButton("Sign out");
    btnSignout.setBounds(276, 731, 100, 29);
    btnSignout.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    LogonScreen logon = new LogonScreen();
    logon.setVisible(true);
    dispose();
    }
    });
    getContentPane().add(btnSignout);
    
    JButton btnExit = new JButton("Exit ");
    btnExit.setBounds(388, 731, 100, 29);
    btnExit.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    System.exit(0);
    }
    });
    getContentPane().add(btnExit);
    
    JComboBox comboBox_1 = new JComboBox(months);
    comboBox_1.setBounds(117, 7, 100, 27);
    getContentPane().add(comboBox_1);
    
    JLabel lblNewLabel = new JLabel("It is currently week 45 of 52");
    lblNewLabel.setBounds(151, 772, 206, 16);
    lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblNewLabel);
    
    JButton button = new JButton("<");
    button.setBounds(327, 5, 46, 29);
    getContentPane().add(button);
    
    JButton button_1 = new JButton(">");
    button_1.setBounds(468, 6, 46, 29);
    getContentPane().add(button_1);
    
    JButton btnCreateEvent = new JButton("Create Event");
    btnCreateEvent.setBounds(6, 6, 108, 29);
    btnCreateEvent.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    createEvent create = new createEvent();
    create.setVisible(true);
    }
    });
    getContentPane().add(btnCreateEvent);
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setBounds(59, 49, 287, 45);
    getContentPane().add(lblNewLabel_1);
    
    JButton btnShowWeekView = new JButton("Show week view");
    btnShowWeekView.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		weekView vW = new weekView();
    		vW.setAlwaysOnTop(true);
    		vW.setVisible(true);
    	}
    });
    btnShowWeekView.setBounds(25, 731, 127, 29);
    getContentPane().add(btnShowWeekView);
    
    agenda = new JTable(data, columnNames);
    agenda.setBounds(26, 92, 462, 627);
    getContentPane().add(agenda);
    agenda.setRowHeight(33);
 
    JLabel lblActicity = new JLabel("Activity");
    lblActicity.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    lblActicity.setBounds(140, 59, 200, 35);
    getContentPane().add(lblActicity);
    
    JLabel lblTime = new JLabel("Time");
    lblTime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    lblTime.setBounds(26, 50, 144, 53);
    getContentPane().add(lblTime);
    
    JLabel lblTodayIs = new JLabel(Controller.getmonthofyear() + " " + Controller.getdayofmonth() + " - " + Controller.getYear());
    lblTodayIs.setHorizontalAlignment(SwingConstants.TRAILING);
    lblTodayIs.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    lblTodayIs.setBounds(298, 64, 189, 16);
    getContentPane().add(lblTodayIs);
    
    JLabel lblNewLabel_2 = new JLabel(Controller.getDay());
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
    lblNewLabel_2.setBounds(406, 36, 82, 16);
    getContentPane().add(lblNewLabel_2);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(520, 870);
    setVisible(true);
  }
  
  
  String[] columnNames =  {"Time", "Activity"};
  Object [][] data = {
		  	{"06.00", null},
			{"07.00", null},
			{"08.00", null},
			{"09.00", null},
			{"10.00", null},
			{"11.00", null},
			{"12.00", null},
			{"13.00", null},
			{"14.00", null},
			{"15.00", null},
			{"16.00", null},
			{"17.00", null},
			{"18.00", null},
			{"19.00", null},
			{"20.00", null},
			{"21.00", null},
			{"22.00", null},
			{"23.00", null},
			{"24.00", null},


			
  };
  private JTable agenda;
}


 