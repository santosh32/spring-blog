package in.spring4buddies.application.structural.decorator;

public class NuttyDecorator extends IcecreamDecorator {

	public NuttyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addNuts();
	}

	private String addNuts() {
		return " + cruncy nuts";
	}
}