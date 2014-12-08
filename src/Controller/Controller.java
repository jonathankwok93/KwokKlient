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
	public static String QOTD = "Default Quote of the Day";

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
		}else if(username.equals(testpassword)){
			return 3;
		}else if(username.equals("")){
			return 6;
		}else{
			return 1;
			
		}
	}


	public static boolean loginMessage(int i){
		if (i == 0){
			cal cal = new cal();
			cal.setVisible(true);
			return true;
		}
		else if(i==1){
			userMessage um = new userMessage("The user does not exist");
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
		}else if(i == 6){
			userMessage um = new userMessage("Please enter a username to continue");
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

		switch (monthofyear){
		case 0:
			return "January";
		case 1:
			return "February";
		case 2:
			return "March";
		case 3:
			return "April";
		case 4:
			return "Maj";
		case 5:
			return "June";
		case 6:
			return "July";
		case 7:
			return "August";
		case 8:
			return "September";
		case 9:
			return "October";
		case 10:
			return "November";
		case 11:
			return "December";
		default:
			return String.valueOf(monthofyear--);
		}


		//		if (monthofyear == 0)
		//			return "January";
		//		else if (monthofyear == 1)
		//			return "February";
		//		else if (monthofyear == 2)
		//			return "March";
		//		else if (monthofyear == 3)
		//			return "April";
		//		else if (monthofyear == 4)
		//			return "May";
		//		else if (monthofyear == 5)
		//			return "June";
		//		else if (monthofyear == 6)
		//			return "July";
		//		else if (monthofyear == 7)
		//			return "August";
		//		else if (monthofyear == 8)
		//			return "September";
		//		else if (monthofyear == 9)
		//			return "October";
		//		else if (monthofyear == 10)
		//			return "November";
		//		else if (monthofyear == 11)
		//			return "December";
		//		else
		//			return "error recieving month";

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

	static int today = Controller.getdayofmonth();
	static int offset = 0;
	static int SatDay = today + 7 ;
	static int SunDay = today + 8 ;
	static int MonDay = today + 2 ;
	static int TueDay = today + 3 ;
	static int WedDay = today + 4;
	static int ThuDay = today + 5;
	static int FriDay = today + 6; 

	//	static int SatDay = today + 7 + offset;
	//	static int SunDay = today + 8 + offset;
	//	static int MonDay = today + 2 + offset;
	//	static int TueDay = today + 3 + offset;
	//	static int WedDay = today + 4 + offset;
	//	static int ThuDay = today + 5 + offset;
	//	static int FriDay = today + 6 + offset;

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
		if(MonDay <= 31){
			MonDay += off;}
		else{
			MonDay = 1;}

		if(TueDay <= 31){
			TueDay += off;}
		else{
			TueDay = 1;}

		if(WedDay <= 31){
			WedDay += off;}
		else{
			setWedDay(1);}

		if(ThuDay <= 31){
			ThuDay += off;}
		else{
			ThuDay = 1;}

		if(FriDay <= 31){
			FriDay += off;}
		else {
			FriDay = 1;}

		if(SatDay <= 31){
			SatDay += off;}
		else{
			SatDay = 1;}

		if(SunDay <= 31){
			SunDay += off;}
		else {
			SunDay = 1;}
	}

	public static void setSatDay(int offset) {
		SatDay = offset;
	}
	public static String getSunDay() {
		return String.valueOf(SunDay);
	}
	public void setSunDay(int offset) {
		SunDay = offset;
	}
	public static String getTueDay() {
		return String.valueOf(TueDay);
	}
	public void setTueDay(int offset) {
		TueDay = offset;
	}
	public static  String getWedDay() {
		return String.valueOf(WedDay);
	}
	public static void setWedDay(int offset) {
		WedDay = offset;
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
		FriDay = offset;
	}
	public static String getMonDay() {
		return String.valueOf(MonDay);

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
