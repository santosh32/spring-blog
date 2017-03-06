package in.spring4buddies.application.jaxb.helper;

import in.spring4buddies.application.jaxb.Students;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

@Component
public class JaxbHelper {

	@Autowired
	private Marshaller marshaller;

	@Autowired
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void marshal(Object jaxbClass, String filename) throws IOException {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(filename);
			marshaller.marshal(jaxbClass, new StreamResult(outputStream));
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	public Students unmarshal(String filename) throws IOException {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filename);
			return (Students) unmarshaller.unmarshal(new StreamSource(inputStream));
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}
