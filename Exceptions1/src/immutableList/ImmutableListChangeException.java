package immutableList;

public class ImmutableListChangeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2692669165007956884L;

	public ImmutableListChangeException() {
		super();
	}

	public ImmutableListChangeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ImmutableListChangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ImmutableListChangeException(String message) {
		super(message);
	}

	public ImmutableListChangeException(Throwable cause) {
		super(cause);
	}

	
	
}
