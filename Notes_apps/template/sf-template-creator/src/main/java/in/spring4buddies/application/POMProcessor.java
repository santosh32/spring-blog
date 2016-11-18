package in.spring4buddies.application;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.maven.pom._4_0.Project;

public class POMProcessor {

	private static JAXBContext jaxbContext;

	public static void process(String project_path, String artifact_name) throws Exception {

		jaxbContext = JAXBProcessor.process(Project.class);

		String pomLocation = project_path + "/" + artifact_name + "/pom.xml";

		marshal(pomLocation, unmarshal(pomLocation, artifact_name));
	}

	public static Project unmarshal(String pomLocation, String artifact_name) throws Exception {

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		Project project = (Project) unmarshaller.unmarshal(new File(pomLocation));

		project.setArtifactId(artifact_name);
		project.setName(artifact_name);

		return project;
	}

	public static void marshal(String pomLocation, Project project) throws Exception {

		Marshaller marshaller = jaxbContext.createMarshaller();

		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		marshaller.marshal(project, new File(pomLocation));
	}
}
