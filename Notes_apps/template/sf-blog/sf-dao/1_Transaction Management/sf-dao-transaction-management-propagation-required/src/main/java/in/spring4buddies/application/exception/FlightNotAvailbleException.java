package in.spring4buddies.application.exception;

public class FlightNotAvailbleException extends Exception {

	private static final long serialVersionUID = 246673960597087108L;

	public FlightNotAvailbleException() {
	}

	public FlightNotAvailbleException(String message) {
		super(message);
	}

	public FlightNotAvailbleException(Throwable cause) {
		super(cause);
	}

	public FlightNotAvailbleException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightNotAvailbleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}