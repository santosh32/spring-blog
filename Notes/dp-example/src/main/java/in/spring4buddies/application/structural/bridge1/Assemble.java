package in.spring4buddies.application.structural.bridge1;

public class Assemble implements Workshop {

	@Override
	public void work() {
		System.out.println(" Assembled.");
	}
}
