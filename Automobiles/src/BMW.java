
public class BMW extends Car {

	public BMW(double mileage, String wheelDrive) {
		super(mileage, wheelDrive);
	}
	
	public void drift(int wheelDamage){
		setMileage(getMileage() + wheelDamage);
	}

}
