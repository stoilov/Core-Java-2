package atomicInteger;

public class MyAtomicIntDemo {

	public static void main(String[] args) {
		int number = 5;

		System.out.printf("Initial: %d\n", number);

		long start_time = System.nanoTime();

		number++;

		long end_time = System.nanoTime();
		long difference = end_time - start_time;

		System.out.printf("No atomic: %d milliseconds\nNumber: %d\n",
				difference, number);

		MyAtomicInt atomic = new MyAtomicInt(5);

		start_time = System.nanoTime();

		atomic.incrementAndGet();

		end_time = System.nanoTime();
		difference = end_time - start_time;

		System.out.printf("Atomic: %d milliseconds\nNumber: %d\n", difference,
				atomic.intValue());
	}

}
