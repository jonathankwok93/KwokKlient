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

public class Calendar extends JFrame {
  String[] years = {"2014","2015", "2016", "2017", "2018", "2019", "2020" };
  String[] viewMode = {"Month view", "Agenda view", "Week view"};

  JComboBox comboBox = new JComboBox(years);

  String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
      "September", "October", "November", "December" };

  JList list = new JList(months);

  CalendarModel model = new CalendarModel();

  JTable table = new JTable(model);
  

  public Calendar() {
    super();
    
    getContentPane().setLayout(null);
    comboBox.setBounds(526, 210, 82, 30);
    comboBox.setSelectedIndex(0);
    comboBox.addItemListener(new ComboHandler());
    table.setBounds(57, 81, 551, 117);
    getContentPane().add(comboBox);
    table.setGridColor(Color.black);
    table.setShowGrid(true);
    getContentPane().add(table);
    list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    list.setBounds(57, 210, 135, 102);
    getContentPane().add(list);
    list.setSelectedIndex(3);
    
    JButton btnToday = new JButton("Today");
    btnToday.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    }
    });
    btnToday.setBounds(475, 40, 100, 29);
    getContentPane().add(btnToday);
    
    JButton btnSignout = new JButton("Sign out");
    btnSignout.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    LogonScreen logon = new LogonScreen();
    logon.setVisible(true);
    dispose();
    }
    });
    btnSignout.setBounds(402, 302, 100, 29);
    getContentPane().add(btnSignout);
    
    JButton btnExit = new JButton("Exit ");
    btnExit.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    System.exit(0);
    }
    });
    btnExit.setBounds(517, 302, 91, 29);
    getContentPane().add(btnExit);
    
    JComboBox comboBox_1 = new JComboBox(months);
    comboBox_1.setBounds(429, 212, 100, 27);
    getContentPane().add(comboBox_1);
    
    JLabel lblNewLabel = new JLabel("It is currently week " + getDateInfo.getWeekNum()
    + " of 52");
    lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNewLabel.setBounds(402, 24, 206, 16);
    getContentPane().add(lblNewLabel);
    
    JComboBox comboBox_2 = new JComboBox(viewMode);
    comboBox_2.setBounds(194, 212, 135, 27);
    getContentPane().add(comboBox_2);
    
    JButton button = new JButton("<");
    button.setBounds(434, 40, 46, 29);
    getContentPane().add(button);
    
    JButton button_1 = new JButton(">");
    button_1.setBounds(571, 40, 46, 29);
    getContentPane().add(button_1);
    
    JButton btnCreateEvent = new JButton("Create Event");
    btnCreateEvent.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    createEvent create = new createEvent();
    create.setVisible(true);
    }
    });
    btnCreateEvent.setBounds(324, 211, 108, 29);
    getContentPane().add(btnCreateEvent);
    
    JLabel lblQuoteOfThe = new JLabel("Quote of the day - You don't have to be great to start, but you have to start to be great");
    lblQuoteOfThe.setBounds(66, 343, 551, 16);
    getContentPane().add(lblQuoteOfThe);
    
    JLabel lblNewLabel_1 = new JLabel("");
    //Image img = new ImageIcon(this.getClass().getResource("/cbs_calendar_logo.png")).getImage();
    //lblNewLabel_1.setIcon(new ImageIcon(img));
    lblNewLabel_1.setBounds(59, 24, 287, 45);
    getContentPane().add(lblNewLabel_1);
 
    
    list.addListSelectionListener(new ListHandler());
    model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(700, 400);
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