package nuc.edu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class LocaleTimeUtil {

	public static String getLocaleTime() {
		
		String localeTime = null; 
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy��MM��dd��    HHʱmm��ss��");
		
		localeTime = sd.format( currentDate );
		
		return localeTime;
		
	}
	
}
