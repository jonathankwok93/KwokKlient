import java.util.TimeZone;
import java.util.Calendar;
import java.util.Timer;
public class Logic {
	
	public boolean tjekLogonInfo(String username){
		String usrname = "test";
		String pswrd = null;
		
		if (username == usrname){
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
	
	public static void timeZone(){
		//TimeZone tz = new TimeZone();
		
	}
	
	public static int getdayofmonth(){
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
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
				return "error";
	}
	
	
	
}
