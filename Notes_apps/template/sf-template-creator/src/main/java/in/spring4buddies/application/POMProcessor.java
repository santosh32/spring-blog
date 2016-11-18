package in.spring4buddies.application;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.maven.pom._4_0.Project;

public class POMProcessor {

	public static Project process() throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Project project = (Project) jaxbUnmarshaller.unmarshal(POMProcessor.class.getClassLoader().getResourceAsStream("pom/pom.xml"));

		return project;
	}

	public static void main(String... arg) throws Exception {
		process();
	}
}
