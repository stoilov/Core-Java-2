package paralelPoint;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GetNearestDemo {

	public static void main(String[] args) {
		long start_time = System.currentTimeMillis();

		List<Point> points = GetNearest.generatePoints();

		Map<Point, Point> generated = null;
		try {
			generated = GetNearest.getNearestPoints(points);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end_time = System.currentTimeMillis();

		long difference = TimeUnit.MILLISECONDS
				.toSeconds(end_time - start_time);

		System.out.printf("Time needed: %d seconds\n", difference);

		if (generated != null) {
			System.out.printf("Map size: %d \n", generated.size());
		}
	}
}
