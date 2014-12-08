package GUI;
import javax.swing.AbstractButton;

import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.Controller;
import Data.TCPClient;

import java.awt.Font;

import javax.swing.JTextArea;

public class cal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	String[] years = {"2014","2015", "2016", "2017", "2018", "2019", "2020" };
	String[] viewMode = {"Month view", "Agenda view", "Week view"};
	
  @SuppressWarnings("unchecked")
  JComboBox comboBox = new JComboBox(years);

  String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
      "September", "October", "November", "December" };

  CalendarModel model = new CalendarModel();
  JTable agendaTable1= new JTable(model);


  public cal() {
    super();
    comboBox.setBounds(218, 5, 82, 30);
    comboBox.setSelectedIndex(0);
  // comboBox.addItemListener(new ItemListener());
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
    
    offset.setMonth(Controller.getMonth());
    
    JButton btnSignout = new JButton("Sign out");
    btnSignout.setBounds(288, 792, 100, 29);
    btnSignout.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    Login logon = new Login();
    logon.setVisible(true);
    dispose();
    }
    });
    getContentPane().add(btnSignout);
    
    JButton btnExit = new JButton("Exit ");
    btnExit.setBounds(388, 792, 100, 29);
    btnExit.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    	dispose();
    	System.exit(0);
    }
    });
    getContentPane().add(btnExit);
    
    JComboBox comboBox_1 = new JComboBox(months);
    comboBox_1.setBounds(117, 7, 100, 27);
    getContentPane().add(comboBox_1);
    
    JLabel lblNewLabel = new JLabel("It is currently week " + Controller.getweekofyear());
    lblNewLabel.setBounds(152, 826, 206, 16);
    lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
    getContentPane().add(lblNewLabel);
  
    
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
    
    JButton btnShowWeekView = new JButton("Show week view");
    btnShowWeekView.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		weekView vW = new weekView();
    		vW.setAlwaysOnTop(true);
    		vW.setVisible(true);
    	}
    });
    btnShowWeekView.setBounds(26, 792, 127, 29);
    getContentPane().add(btnShowWeekView);
    
//    agenda = new JTable(data, columnNames);
//    agenda.setBounds(26, 153, 305, 627);
//    getContentPane().add(agenda);
//    agenda.setRowHeight(33);
 
    final JLabel lblActicity = new JLabel("Activity");
    lblActicity.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    lblActicity.setBounds(117, 116, 200, 35);
    getContentPane().add(lblActicity);
    
    JLabel lblTime = new JLabel("Time");
    lblTime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    lblTime.setBounds(26, 107, 144, 53);
    getContentPane().add(lblTime);
    
    JLabel lblNewLabel_2 = new JLabel(Controller.getDay());
    lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
    lblNewLabel_2.setBounds(26, 107, 82, 16);
    getContentPane().add(lblNewLabel_2);
    
   
    
    final JLabel lblMonth = new JLabel(offset.getmonthstring(offset.getMonthInt()));
    lblMonth.setBounds(16, 46, 82, 27);
    getContentPane().add(lblMonth);
    
    final JLabel lblDay = new JLabel(offset.getDay());
    lblDay.setHorizontalAlignment(SwingConstants.CENTER);
    lblDay.setBounds(89, 44, 68, 30);
    getContentPane().add(lblDay);
    
    
    //lblMonth.setText(offset.getmonthstring(offset.getMonthInt()));
    //lblDay.setText(offset.getDay());
    
    JButton button_1 = new JButton(">");
    button_1.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		offset.offplus(1);
    		//lblMonth.setText(offset.getmonthstring(offset.getMonthInt()));
    		//lblDay.setText(offset.getDay());
    		lblDay.repaint();
    		lblMonth.repaint();
    	}
    });
    	    
    button_1.setBounds(468, 6, 46, 29);
    getContentPane().add(button_1);
    

    JButton button = new JButton("<");
    button.addMouseListener(new MouseAdapter() {

		@Override
    	public void mouseClicked(MouseEvent e) {
    	
    		offset.offminus(1);
    		lblDay.repaint(); 
    		lblMonth.repaint();
  
    	}
    });
    button.setBounds(327, 5, 46, 29);
    getContentPane().add(button);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(26, 153, 767, 481);
    getContentPane().add(textArea);
    
    try{
    	textArea.setText(Controller.getCBSCalendar());
    	
    	JTextArea textArea_1 = new JTextArea();
    	textArea_1.setBounds(26, 656, 767, 124);
    	textArea_1.setText(Controller.getWeather());
    	getContentPane().add(textArea_1);
    }catch(Exception e){
    	textArea.setText("error revieving cbs calendar");
    }
       		
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(820, 870);
    setVisible(true);
  }
  
  
} 


class offset{
	static int defaultmonth = Controller.getmonthofyearint();
	static int defaultday = Controller.getdayofmonth();
	static int defaultyear = Controller.getYear();
	static int offset = 0;
	
	static int month = defaultmonth;
	static int day = defaultday;
	static int year = defaultyear;
	
	
	public static void offminus(int off){
	
		month++;
		day++;
		/* 	
	 
			if (day >= 31){
				day -= off;
			}else{
				month -= off;
			}
			
			if (month == 0){
				year --;
				month = 1;			
	
		}
		 */
	}
	
	public static void setMonth(int i){
		month = i;
	}

	public static void offplus(int off){
		
	/*
		if (day > 31){
			day += off;
		}else{
			month += off;
		}
		
		if (month == 12){
			year ++;
			month = 1;
		}
	*/		
	}	
	
	public void setMonth(){
		month = Controller.getMonth();
	}
	
	public static String getMonth(){
		return String.valueOf(month);
	}
	
	public static int getMonthInt(){
		return month;
	}
	
	public static String getYear(){
		return String.valueOf(year);
	}
	
	public static String getDay(){
		return String.valueOf(day);
	}
	
	public static String getmonthstring(int monthofyear){
		try{
		if (monthofyear == 1)
			return "January";
			else if (monthofyear == 2)
				return "February";
			else if (monthofyear == 3)
				return "March";
			else if (monthofyear == 4)
				return "April";
				else if (monthofyear == 5)
					return "May";
				else if (monthofyear == 6)
					return "June";
				else if (monthofyear == 7)
					return "July";
				else if (monthofyear == 8)
					return "August";
				else if (monthofyear == 9)
					return "September";
				else if (monthofyear == 10)
					return "October";
				else if (monthofyear == 11)
					return "November";
				else if (monthofyear == 12)
					return "December";
				else
					return "error";
		}catch(Exception e){
			e.printStackTrace();
			return String.valueOf(monthofyear);
		}
	}
	
	public static int getyear(){
		return Controller.getYear();
	}
	
	
	 
}

