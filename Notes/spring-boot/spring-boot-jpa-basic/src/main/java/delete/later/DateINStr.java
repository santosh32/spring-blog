package delete.later;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateINStr {
	
	
	public static void main(String[] args) throws Exception {

		GregorianCalendar gc = new GregorianCalendar();
		XMLGregorianCalendar xc = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gc);

		IntageInfo intageInfo = new IntageInfo();
		intageInfo.setActualEnd(xc);

		OutageInfo outageInfo = new OutageInfo();
		Date date = intageInfo.getActualEnd().toGregorianCalendar().getTime();
		outageInfo.setActualEnd(new Date(date.toGMTString()));

		System.out.println("Date in GMT == " + intageInfo.getActualEnd().toString());
		System.out.println(intageInfo.getActualEnd().toGregorianCalendar().getTime().toGMTString());
		System.out.println("Date in GMT == " + intageInfo.getActualEnd().toXMLFormat());
		System.out.println("Date in GMT == " + outageInfo.getActualEnd());
		System.out.println("Date in GMT == " + outageInfo.getActualEnd().toString());
		System.out.println("Date in GMT == " + outageInfo.getActualEnd().toGMTString());
		System.out.println("Date in GMT == " + outageInfo.getActualEnd().toLocaleString());
		
	}
	
	
	private static Date convertUTCToGMT(Date utcDate) throws Exception {

		System.out.println("Given Local date = " + utcDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
//		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmtDateInStr = dateFormat.format(utcDate);
		
		
		Date gmtDateInDate = dateFormat.parse(gmtDateInStr);

		System.out.println("GMT in String Type = " + gmtDateInStr);
		System.out.println("GMT in DATE Type = " + gmtDateInDate);
		
//		TimeZone.setDefault(tz);
//		System.out.println("GMT in DATE Type = " + gmtDateInDate);
//		
//		System.out.println("GMT in DATE Type = " + dateFormat.parse(dateFormat.format(utcDate)));
		
		return gmtDateInDate;
		
		
		
		
//		 DateTime dateTime = new DateTime(gmtDateInDate);
//		
//		DateTimeFormatter df3 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss z")
//				.withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT")))
//				.withZone(DateTimeZone.forID("Europe/London"));
//		
//		
//		System.out.println(dateTime.toString(df3));
//		System.out.println(dateTime.toDate());
//		
//		 // get current moment in default time zone
//	    DateTime dt = new DateTime();
//	    // translate to London local time
//	    DateTime dtLondon = dt.withZone(DateTimeZone.forID("Europe/London"));
//	    
//	    System.out.println(dt);
//	    System.out.println(dtLondon);

//		return null;
	}

//	private static Date convertUTCToGMT(Date utcDate) throws Exception {
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//		String utcDateInStr = dateFormat.format(utcDate);
//		System.out.println("Date in UTC == " + utcDateInStr);
//
//		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//		dateFormat1.setTimeZone(TimeZone.getTimeZone("GMT"));
//		Date utcDateInDate = dateFormat1.parse(utcDateInStr);
//		String test = dateFormat1.format(utcDateInDate);
//		System.out.println(test);
//		
//		return utcDateInDate;
//	}

}
