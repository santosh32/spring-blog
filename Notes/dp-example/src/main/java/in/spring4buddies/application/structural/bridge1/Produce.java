package in.spring4buddies.application.structural.bridge1;

public class Produce implements Workshop {

	@Override
	public void work() {
		System.out.print("Produced");
	}
}
