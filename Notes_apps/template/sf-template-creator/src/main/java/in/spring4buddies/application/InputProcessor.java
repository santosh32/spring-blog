package in.spring4buddies.application;

import in.spring4buddies.application.xsd.Modules;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class InputProcessor {

	public static List<Modules> process() throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(Modules.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		List<String> inputFiles = IOUtils.readLines(InputProcessor.class.getClassLoader().getResourceAsStream("."), Charsets.UTF_8);

		List<Modules> modules = new ArrayList<Modules>();

		for (String inputFile : inputFiles) {

			if (StringUtils.startsWith(inputFile, "module") && StringUtils.endsWith(inputFile, "xml")) {

				Modules module = (Modules) jaxbUnmarshaller.unmarshal(Application.class.getClassLoader().getResourceAsStream(inputFile));
				modules.add(module);
			}
		}

		return modules;
	}
}
