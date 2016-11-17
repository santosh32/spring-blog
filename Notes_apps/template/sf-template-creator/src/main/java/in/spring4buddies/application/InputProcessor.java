package in.spring4buddies.application;

import in.spring4buddies.application.xsd.Modules;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class InputProcessor {

	public static Modules process() throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Modules.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (Modules) jaxbUnmarshaller.unmarshal(Application.class
				.getClassLoader().getResourceAsStream(ProjectConstant.INPUT_FILE));
	}
}
