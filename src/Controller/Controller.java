package Controller;
import java.util.Calendar;
import GUI.cal;
import GUI.userMessage;

public class Controller {

	static Calendar cal = Calendar.getInstance();

	public static int month = cal.get(Calendar.MONTH);
	public static int day = cal.get(Calendar.DAY_OF_MONTH);
	public static int weekday = (cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	public static int year = cal.get(Calendar.YEAR);
	public static int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
	public static int mon = cal.get(Calendar.MONDAY);
	public static String QOTD = null;

	public static String testusername = "test";
	public static String testpassword = "123";

	public static boolean createEvent(int startday, int startmonth, int endday, int endmonth,
			int startyear, int endyear, String location, String notes){
		if (sendEvent(startday, startmonth, endday, endmonth, startyear, endyear, location, notes)){ //Send event to server
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings("unused")
	public static boolean sendEvent(int startday, int startmonth, int endday, int endmonth,
			int startyear, int endyear, String location, String notes){
		if(true){//Connect to server
			userMessage um = new userMessage("The event has been created successfully");
			um.setVisible(true);
			return true;
		}else{
			userMessage um = new userMessage("The event could not be created");
			um.setVisible(true);
			return false;
		}

	}

	public static int login (String username, String password){

		if(username.equals(testusername) && password.equals(testpassword)){
			return 0;
		}else if(username.equals(testusername) ){
			return 3;
		}else{
			return 5;
		}

		//if(username.equals("admin"))
		//return 0; // if email does not exist
		//return 2; // if user is inactive
		//return 3; // if password dows not match
		//return 4; // if usser is admin 
	}

	public static boolean loginMessage(int i){
		if (i == 0){
			cal cal = new cal();
			cal.setVisible(true);
			return true;
		}
		if(i==1){
			userMessage um = new userMessage("The email does not exist");
			um.setVisible(true);
			return false;
		}else if(i == 2){
			userMessage um = new userMessage("The user is inactive");
			um.setVisible(true);
			return false;
		}else if(i == 3){
			userMessage um = new userMessage("The password does not match");
			um.setVisible(true);
			return false;
		}else if(i == 4){
			userMessage um = new userMessage("This user is a administrator, please log in from the server");
			um.setVisible(true);
			return false;
		}else{
			userMessage um = new userMessage("Error logging in");
			um.setVisible(true);
			return false;
		}
	}

	public static void updateQOTD(){
		QOTD = "String from server";
	}

	public static String getQOTD(int i){
		if (i == 1)
			return QOTD;
		else if (i > 1)
			updateQOTD();
		return QOTD;
	}

	public static int getDayOfWeek(){
		return dayofweek;
	}

	public static int getMon() {
		return mon;
	}


	public void setMon(int mon) {
		Controller.mon = mon;
	}


	public static int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getWeekday() {
		return weekday;
	}


	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public boolean tjekLogonInfo(String username){
		String usrname = "test";
		if (username.equals(usrname)){
			return true;
		}else{
			return true;	
		}
	}


	public String rememberUsrname(String usrname){
		String rememberUsrname = usrname;
		return rememberUsrname;

	}

	public String rememberPswrd(String password){
		String rememberPassword = password;
		return rememberPassword;

	}

	public boolean returnTrue(String test){
		return true;
	}

	public static int getdayofmonth(){
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}

	public static int getmonthofyearint(){
		Calendar cal = Calendar.getInstance();
		int monthofyear = cal.get(Calendar.MONTH);
		monthofyear ++;
		return monthofyear;
	}

	public static String getmonthofyear(){
		Calendar cal = Calendar.getInstance();
		int monthofyear = cal.get(Calendar.MONTH);
		monthofyear++;

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

	}


	public int getdayofweekinmonth(){
		Calendar cal = Calendar.getInstance();
		int dayOfweekinMonth = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		return dayOfweekinMonth;
	}

	public static int getweekofyear(){
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.WEEK_OF_YEAR);
		return dayOfMonth;
	}

	public static int getFirstDayOfWeek(){
		Calendar cal = Calendar.getInstance();
		Calendar first = (Calendar) cal.clone();
		int firstDayOfWeek = first.getFirstDayOfWeek();
		return firstDayOfWeek;
	}

	public static int getYear(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static String getDay(){
		Calendar cal = Calendar.getInstance();
		int Day = cal.get(Calendar.DAY_OF_WEEK);
		if (Day == 0)
			return "Saturday";
		else if (Day == 1)
			return "Sunday";
		else if (Day == 2)
			return "Monday";
		else if (Day == 3)
			return "Tuesday";
		else if (Day == 4)
			return "Wednesday";
		else if (Day == 5)
			return "Thusday";
		else if (Day == 6)
			return "Friday";
		else
			return "error displaying day";
	}

	public static void getTodayEvent(){
		switch (String.valueOf(getDayOfWeek() + 1)){
		case "1":
			getMondayEvent();
			break;
		case "2":	
			getTuesdayEvent();
			break;
		case "3":
			getWednesdayEvent();
			break;
		case "4":
			getThursdayEvent();
			break;
		case "5":
			getFridayEvent();
			break;
		case "6":
			getSaturdayEvent();
			break;
		case "7":
			getSundayEvent();
			break;
		default:
			userMessage um = new userMessage("Error loading event");
			um.setVisible(true);
		}		
	}

	public static String getMondayEvent(){
		return "Event for monday";
		//Sends a Json request to server
	}

	public static String getTuesdayEvent(){
		return "";
		//Sends a Json request to server
	}

	public static String getWednesdayEvent(){
		return "";
		//Sends a Json request to server
	}

	public static String getThursdayEvent(){
		return "";
		//Sends a Json request to server
	}

	public static String getFridayEvent(){
		return "";
		//Sends a Json request to server
	}

	public static String getSaturdayEvent(){
		return "";
		//Sends a Json request to server
	}

	public static String getSundayEvent(){
		return "";
		//Sends a Json request to server
	}

}
