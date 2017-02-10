package in.spring4buddies.application.exception;

public class HotelNotAvailbleException extends Exception {

	private static final long serialVersionUID = 8966252054318955307L;

	public HotelNotAvailbleException() {
	}

	public HotelNotAvailbleException(String message) {
		super(message);
	}

	public HotelNotAvailbleException(Throwable cause) {
		super(cause);
	}

	public HotelNotAvailbleException(String message, Throwable cause) {
		super(message, cause);
	}

	public HotelNotAvailbleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}