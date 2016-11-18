package in.spring4buddies.application;

import javax.xml.bind.JAXBContext;

public class JAXBProcessor {

	public static JAXBContext process(@SuppressWarnings("rawtypes") Class clazz) throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

		return jaxbContext;
	}

}
