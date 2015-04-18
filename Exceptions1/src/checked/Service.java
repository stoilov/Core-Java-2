package checked;

public class Service {

	public static void useService(boolean hasConnection)
			throws ServiceNotAvailableAtTheMoment {

		if (hasConnection) {
			System.out.println("Connecting...");
		} else {
			throw new ServiceNotAvailableAtTheMoment();
		}

	}

	public static void main(String[] args) {
		try {
			useService(false);
		} catch (ServiceNotAvailableAtTheMoment sna) {
			System.out.println(sna.getMessage());
		}
	}

}
