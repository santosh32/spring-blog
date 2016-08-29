package delete.later;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateEx2 {

	public static void main(String[] args) throws Exception {
		
		
//		TimeZone timeZone = TimeZone.getTimeZone("UTC");
//		Calendar calendar = Calendar.getInstance(timeZone);
//		SimpleDateFormat simpleDateFormat = 
//		       new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//		simpleDateFormat.setTimeZone(timeZone);
//
//		System.out.println("Time zone: " + timeZone.getID());
//		System.out.println("default time zone: " + TimeZone.getDefault().getID());
//		System.out.println();
//
//		System.out.println("UTC:     " + simpleDateFormat.format(calendar.getTime()));
//		System.out.println("Default: " + calendar.getTime());
//
//		Calendar cal_Two = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
//		System.out.println(cal_Two.getTime());

		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		System.out.println(tz);
		Calendar cal_Three = Calendar.getInstance();
		System.out.println(cal_Three.getTime());
		TimeZone.setDefault(tz);
		System.out.println(tz);
	}

}
