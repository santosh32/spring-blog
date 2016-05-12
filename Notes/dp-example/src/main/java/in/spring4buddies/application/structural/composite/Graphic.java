package in.spring4buddies.application.structural.composite;

//Component interface
public interface Graphic {
	
	public void remove(Graphic g);

	public Graphic get(int index);

	public void paint();
}
