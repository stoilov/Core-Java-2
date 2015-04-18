package statistics;

import java.util.ArrayList;
import java.util.Arrays;

public class StatisticsMain {

	public static void main(String[] args) {
		ArrayList<Integer> statsArr = new ArrayList<>(
				Arrays.asList(13, 18, 13, 14, 13, 16, 14, 21, 13));
		StatisticalInfo<Integer> stats = new StatisticalInfo<Integer>(statsArr);
		for (Integer integer : stats) {
			System.out.print(integer + " ");
		}
		System.out.println(stats.getMean());
		System.out.println(stats.getMedian());
		System.out.println(stats.getMode());
		System.out.println(stats.getRange());
		stats.add(13);
	}
	
}
