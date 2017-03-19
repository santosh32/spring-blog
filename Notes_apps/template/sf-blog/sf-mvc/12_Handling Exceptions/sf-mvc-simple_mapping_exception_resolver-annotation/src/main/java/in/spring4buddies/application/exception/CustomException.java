package in.spring4buddies.application.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;
	private String name;

	public CustomException(String message, String name) {
		this.message = message;
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}