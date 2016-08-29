package delete.later;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ZodaEX {
	
	
	public static void main(String[] args) throws Exception {

		GregorianCalendar gc = new GregorianCalendar();
		XMLGregorianCalendar xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

		IntageInfo intageInfo = new IntageInfo();
		intageInfo.setActualEnd(xc);

		OutageInfo outageInfo = new OutageInfo();

		Date intageDate = intageInfo.getActualEnd().toGregorianCalendar().getTime();
		
		outageInfo.setActualEnd(intageDate);
		
		System.out.println("intageDate = "+intageDate);
	    
		DateTime dateTime = new DateTime(intageDate);
		System.out.println("dateTime = "+dateTime);
		
	    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss z")
	    							.withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT")));
//	    							.withZone(DateTimeZone.forID("Europe/London"));

	    System.out.println(dateTime.toString(dateTimeFormatter));
	    dateTime.toDate();
	    System.out.println(dateTime.toDate());

	    
	    final Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.setTimeZone(TimeZone.getTimeZone("GMT"));
	    System.out.println(cal.getTime());
	    
	    
	}
	
	
	

}
