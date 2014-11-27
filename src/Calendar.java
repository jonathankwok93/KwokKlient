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

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Font;

public class Calendar extends JFrame {
  String[] years = {"2014","2015", "2016", "2017", "2018", "2019", "2020" };
  String[] viewMode = {"Month view", "Agenda view", "Week view"};

  @SuppressWarnings("unchecked")
JComboBox comboBox = new JComboBox(years);

  String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
      "September", "October", "November", "December" };

  @SuppressWarnings("unchecked")
JList list = new JList(months);

  CalendarModel model = new CalendarModel();

  JTable table = new JTable(model);
  JTable agendaTable1= new JTable(model);


  public Calendar() {
    super();
    comboBox.setBounds(218, 5, 82, 30);
    comboBox.setSelectedIndex(0);
    comboBox.addItemListener(new ComboHandler());
    getContentPane().setLayout(null);
    getContentPane().add(comboBox);
    table.setBounds(18, 97, 328, 112);
    table.setGridColor(Color.black);
    table.setShowGrid(true);
    getContentPane().add(table);
    list.setBounds(194, 221, 152, 102);
    list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    getContentPane().add(list);
    list.setSelectedIndex(3);
    
    JButton btnToday = new JButton("Today");
    btnToday.setBounds(678, 63, 100, 29);
    btnToday.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    }
    });
    getContentPane().add(btnToday);
    
    JButton btnSignout = new JButton("Sign out");
    btnSignout.setBounds(628, 763, 100, 29);
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
    btnExit.setBounds(720, 763, 100, 29);
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
    lblNewLabel.setBounds(312, 11, 206, 16);
    lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblNewLabel);
    
    JButton button = new JButton("<");
    button.setBounds(638, 63, 46, 29);
    getContentPane().add(button);
    
    JButton button_1 = new JButton(">");
    button_1.setBounds(774, 63, 46, 29);
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
    
    JLabel lblQuoteOfThe = new JLabel("Quote of the day - You don't have to be great to start, but you have to start to be great"); //Get string from server
    lblQuoteOfThe.setBounds(177, 804, 551, 16);
    getContentPane().add(lblQuoteOfThe);
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setBounds(59, 24, 287, 45);
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
    btnShowWeekView.setBounds(508, 763, 127, 29);
    getContentPane().add(btnShowWeekView);
    
    table_1 = new JTable(data, columnNames);
    table_1.setBounds(358, 97, 462, 627);
    getContentPane().add(table_1);
    table_1.setRowHeight(33);
 
    JLabel lblActicity = new JLabel("Activity");
    lblActicity.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    lblActicity.setBounds(539, 59, 200, 35);
    getContentPane().add(lblActicity);
    
    JLabel lblTime = new JLabel("Time");
    lblTime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    lblTime.setBounds(358, 50, 144, 53);
    getContentPane().add(lblTime);
    
    JLabel lblTodayIs = new JLabel(Logic.getmonthofyear() + " " + Logic.getdayofmonth() + " - " + Logic.getYear());
    lblTodayIs.setHorizontalAlignment(SwingConstants.TRAILING);
    lblTodayIs.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    lblTodayIs.setBounds(631, 10, 189, 16);
    getContentPane().add(lblTodayIs);
    
    JLabel lblNewLabel_2 = new JLabel(Logic.getDay());
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
    lblNewLabel_2.setBounds(738, 35, 82, 16);
    getContentPane().add(lblNewLabel_2);
    
    JLabel lblMonthOverview = new JLabel("Month overview");
    lblMonthOverview.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    lblMonthOverview.setBounds(18, 68, 108, 16);
    getContentPane().add(lblMonthOverview);
    
 
    
    list.addListSelectionListener(new ListHandler());
    model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(850, 900);
    setVisible(true);
  }

  public class ComboHandler implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
      model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());
      table.repaint();
    }
  }

  public class ListHandler implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
      model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());
      table.repaint();
    }
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
  private JTable table_1;
}
class CalendarModel extends AbstractTableModel {
  String[] days = { "Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri" };

  int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  String[][] calendar = new String[7][7];

  public CalendarModel() {
    for (int i = 0; i < days.length; ++i)
      calendar[0][i] = days[i];
    for (int i = 1; i < 7; ++i)
      for (int j = 0; j < 7; ++j)
        calendar[i][j] = " ";
  }

  public int getRowCount() {
    return 7;
  }

  public int getColumnCount() {
    return 7;
  }

  public Object getValueAt(int row, int column) {
    return calendar[row][column];
  }

  public void setValueAt(Object value, int row, int column) {
    calendar[row][column] = (String) value;
  }

  public void setMonth(int year, int month) {
    for (int i = 1; i < 7; ++i)
      for (int j = 0; j < 7; ++j)
        calendar[i][j] = " ";
    java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
    cal.set(year, month, 1);
    int offset = cal.get(java.util.GregorianCalendar.DAY_OF_WEEK) - 1;
    offset += 7;
    int num = daysInMonth(year, month);
    for (int i = 0; i < num; ++i) {
      calendar[offset / 7][offset % 7] = Integer.toString(i + 1);
      ++offset;
    }
  }

  public boolean isLeapYear(int year) {
    if (year % 4 == 0)
      return true;
    return false;
  }

  public int daysInMonth(int year, int month) {
    int days = numDays[month];
    if (month == 1 && isLeapYear(year))
      ++days;
    return days;
  }
}