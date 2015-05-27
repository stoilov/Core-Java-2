package myjunit;

import java.util.Comparator;

public class BeforeComparator implements Comparator<Before> {

	@Override
	public int compare(Before arg0, Before arg1) {
		if (arg0.priority() < arg1.priority()) {
			return -1;
		}
		if (arg0.priority() < arg1.priority()) {
			return 1;
		}

		return 0;
	}

}
