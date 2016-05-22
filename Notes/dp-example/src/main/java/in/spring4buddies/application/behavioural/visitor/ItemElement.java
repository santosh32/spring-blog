package in.spring4buddies.application.behavioural.visitor;

public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}