public class Car implements Vehicle {

	private double mileage;
	private int tyrePercentage;
	private String wheelDrive;
	
	public Car(double mileage, String wheelDrive) {
		setMileage(mileage);
		setWheelDrive(wheelDrive);
	}

	public void setMileage(double mileage) {
		// More logic for validating
		this.mileage = mileage;
	}
	
	@Override
	public double getMileage() {
		return mileage;
	}
	
	public String getWheelDrive() {
		return wheelDrive;
	}

	public void setWheelDrive(String wheelDrive) {
		this.wheelDrive = wheelDrive;
	}

	public int getTyrePercentage() {
		return tyrePercentage;
	}

	public void setTyrePercentage(int tyrePercentage) {
		this.tyrePercentage = tyrePercentage;
	}

	@Override
	public void drive(float distance) {
		setMileage(getMileage() + distance);
	}

}
