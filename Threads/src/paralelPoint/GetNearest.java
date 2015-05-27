package paralelPoint;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class GetNearest {

	private static final int POINTS_NUMBER = 100_000;
	private static final int RANGE = 10_001;
	private static final int THREADS_NUMBER = 4;

	private static Object obj = new Object();

	private static Runnable getRunnable(Map<Point, Point> nearestPoints,
			List<Point> generatedPoints, int half, int number) {

		int start = (number == 0) ? 0 : number * half + 1;
		int end = (number + 1 == THREADS_NUMBER) ? half * THREADS_NUMBER
				: (number + 1) * half + 1;

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					doCalculations(generatedPoints, start, end, nearestPoints);
				}
			}
		};

		return runnable;
	}

	public static List<Point> generatePoints() {
		List<Point> points = new ArrayList<Point>();
		Random random = new Random();
		int x, y;

		for (int i = 0; i < POINTS_NUMBER; i++) {
			x = random.nextInt(RANGE);
			y = random.nextInt(RANGE);
			points.add(new Point(x, y));
		}

		return points;
	}

	// min will always be a little bigger than the random values generated
	private static int setMin() {
		return (int) (Math.pow((RANGE - 0), 2) + Math.pow((RANGE - 0), 2));
	}

	public static Map<Point, Point> getNearestPoints(List<Point> generatedPoints)
			throws InterruptedException {
		Map<Point, Point> nearestPoints = new ConcurrentHashMap<Point, Point>();

		int half = generatedPoints.size() / THREADS_NUMBER; // lol - many halves

		Thread[] threads = new Thread[THREADS_NUMBER];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(getRunnable(nearestPoints, generatedPoints,
					half, i));
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			threads[i].join();
		}

		return nearestPoints;
	}

	public static void doCalculations(List<Point> inPoints, int indexFrom,
			int indexTo, Map<Point, Point> outMap) {
		int distance, min, minIndex = 0;

		for (int i = indexFrom; i < indexTo; i++) {
			min = setMin();

			for (int j = indexFrom; j < indexTo; j++) {
				if (i != j) {

					distance = (int) (Math.pow(
							(inPoints.get(j).getX() - inPoints.get(i).getX()),
							2) + Math.pow((inPoints.get(j).getY() - inPoints
							.get(i).getY()), 2));

					if (min > distance) {
						min = distance;
						minIndex = j;
					}
				}
			}

			outMap.put(inPoints.get(i), inPoints.get(minIndex));

		}
	}

}
