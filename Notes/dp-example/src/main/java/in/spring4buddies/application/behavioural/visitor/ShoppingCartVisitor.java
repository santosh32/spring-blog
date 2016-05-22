package in.spring4buddies.application.behavioural.visitor;

public interface ShoppingCartVisitor {

	int visit(Book book);

	int visit(Fruit fruit);
}
