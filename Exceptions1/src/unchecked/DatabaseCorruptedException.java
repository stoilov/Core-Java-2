package unchecked;

public class DatabaseCorruptedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseCorruptedException() {
		super();
	}

	public DatabaseCorruptedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DatabaseCorruptedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseCorruptedException(String message) {
		super(message);
	}

	public DatabaseCorruptedException(Throwable cause) {
		super(cause);
	}

	

}
