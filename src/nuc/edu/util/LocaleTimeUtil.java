package nuc.edu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class LocaleTimeUtil {

	public static String getLocaleTime() {
		
		String localeTime = null; 
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日    HH时mm分ss秒");
		
		localeTime = sd.format( currentDate );
		
		return localeTime;
		
	}
	
}
