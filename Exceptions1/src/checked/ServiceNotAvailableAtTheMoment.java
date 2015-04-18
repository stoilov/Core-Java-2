package checked;

public class ServiceNotAvailableAtTheMoment extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceNotAvailableAtTheMoment() {
		super("Lost network connection or firewall enabled");
	}

	public ServiceNotAvailableAtTheMoment(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceNotAvailableAtTheMoment(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceNotAvailableAtTheMoment(String message) {
		super(message);
	}

	public ServiceNotAvailableAtTheMoment(Throwable cause) {
		super(cause);
	}

}
