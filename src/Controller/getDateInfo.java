package Controller;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.GregorianCalendar;

public class getDateInfo {

	static Calendar calendar = Calendar.getInstance();
	
	public static int getWeekNum(){
		int weekNum = calendar.get(Calendar.WEEK_OF_YEAR);
		return weekNum;
	}
	
	public int getDayOfMonth(){	
		
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	
	}
	
}
