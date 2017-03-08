package in.spring4buddies.application.jibx.helper;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

@Component
public class JibxHelper {

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

	public Object unmarshal(String filename) throws IOException {
		return unmarshaller.unmarshal(new StreamSource(JibxHelper.class.getClassLoader().getResourceAsStream(filename)));
	}
}
