package in.spring4buddies.application.scope.xml;

public class SpringPrototype {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println(message);
	}
}
