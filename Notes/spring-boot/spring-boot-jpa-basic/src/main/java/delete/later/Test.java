package delete.later;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) throws Exception {

		GregorianCalendar gc = new GregorianCalendar();
		XMLGregorianCalendar xc = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gc);

		IntageInfo intageInfo = new IntageInfo();
		intageInfo.setActualEnd(xc);

		OutageInfo outageInfo = new OutageInfo();

		outageInfo.setActualEnd(convertUTCToGMT(intageInfo.getActualEnd().toGregorianCalendar().getTime()));

		ObjectMapper mapper = new ObjectMapper();
		mapper.setTimeZone(TimeZone.getTimeZone("GMT"));
		String result = mapper.writeValueAsString(outageInfo);
		System.out.println("Date in GMT == " + result);
	}

	private static Date convertUTCToGMT(Date utcDate) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		String utcDateInStr = dateFormat.format(utcDate);
		System.out.println("Date in UTC == " + utcDateInStr);

		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date utcDateInDate = dateFormat.parse(utcDateInStr);
		
		return utcDateInDate;
	}

}
