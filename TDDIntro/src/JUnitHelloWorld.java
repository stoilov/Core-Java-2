public class JUnitHelloWorld {

	public int getNumberOfDigits(int number) {
		int counter = 0;
		while (true) {
			number /= 10;
			counter++;
			if (number == 0) {
				return counter;
			}
		}
	}
}
