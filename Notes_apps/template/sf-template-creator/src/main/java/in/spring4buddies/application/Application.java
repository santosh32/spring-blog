package in.spring4buddies.application;

import in.spring4buddies.application.xsd.Modules;

import java.util.List;

public class Application {

	public static void main(String[] args) throws Exception {

		List<Modules> moduleList = InputProcessor.process();

		for (Modules modules : moduleList) {
			ProjectCreator.process(modules);
		}
	}
}
