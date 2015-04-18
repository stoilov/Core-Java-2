package noNullHashMap;

public class NoNullKeyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoNullKeyException() {
		super();
	}

	public NoNullKeyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoNullKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoNullKeyException(String message) {
		super(message);
	}

	public NoNullKeyException(Throwable cause) {
		super(cause);
	}
	
	

}
