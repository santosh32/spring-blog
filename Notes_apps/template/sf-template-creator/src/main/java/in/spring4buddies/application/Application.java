package in.spring4buddies.application;

public class Application {

	public static void main(String[] args) throws Exception {

		ProjectCreator.process(InputProcessor.process());
	}
}
