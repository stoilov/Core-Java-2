package racecondition;

import java.util.Date;

public class RaceThreads {
	
	private static int times = 2_000_000;
	private static int count = 0;
	private static Object obj = new Object();

	public static synchronized void increment() {
		for (int i = 0; i < times; i++) {
			count++;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread A = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					increment();
				}
			}
		});

		Thread B = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					increment();
				}
			}
		});

		long startTime = new Date().getTime();

		A.start();
		A.join();
		B.start();
		B.join();

		long endTime = new Date().getTime();
		long difference = endTime - startTime;

		System.out.println(count);
		System.out.println(difference);
	}

}
