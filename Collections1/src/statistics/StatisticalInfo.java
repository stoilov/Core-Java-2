package statistics;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StatisticalInfo<E> extends AbstractList<Integer> implements Statistics {

	private ArrayList<Integer> statList = new ArrayList<Integer>();

    StatisticalInfo(ArrayList<Integer> list) {
    	statList = list;
    }
	
	@Override
	public Integer get(int index) {
		return statList.get(index);
	}

	@Override
	public int size() {
		return statList.size();
	}
	
	public boolean add(Integer element) {
		if(element != null) {
			statList.add(element);
		}
		return false;
	}

	@Override
	public int getMean() {
		int sum = 0;
		for (int i = 0; i < statList.size(); i++) {
			sum += statList.get(i);
		}
		
		return sum / statList.size();
	}

	@Override
	public int getMedian() {
		ArrayList<Integer> sorted = statList;
		Collections.sort(sorted);
		
		if (sorted.size() % 2 == 1) {
			return sorted.get(sorted.size() / 2);
		}
		else {
			return (sorted.get(sorted.size() / 2) + sorted.get((sorted.size() / 2) - 1)) / 2;
		}
	}

	@Override
	public int getMode() {
		ArrayList<Integer> sorted = statList;
		Collections.sort(sorted);
		
		int[] valuesCount = new int[sorted.get(sorted.size() - 1) + 1];
		Arrays.fill(valuesCount, 0);
		
		int max = valuesCount[0];
		int maxIndex = 0;
		
		for (int i = 0; i < statList.size(); i++) {
			valuesCount[statList.get(i)]++;
		}
		
		for (int i = 0; i < valuesCount.length; i++) {
			if (max < valuesCount[i]) {
				max = valuesCount[i];
				maxIndex = i;
			}
			
		}
		
		return maxIndex;
	}

	@Override
	public int getRange() {
		ArrayList<Integer> sorted = statList;
		Collections.sort(sorted);
		
		return sorted.get(sorted.size() - 1) - sorted.get(0);
	}	

}
