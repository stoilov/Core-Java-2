import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PairTestIntegers {
	private Pair pair;

	@Before
	public void setUp() {
		Integer one = 1;
		Integer two = 2;
		this.pair = new Pair(one, two);
	}
	
	@Test
	public void equalsTest() {
		Integer one = 1;
		Integer two = 2;
		Pair pair2 = new Pair(one, two);
		assertTrue(pair.equals(pair2));
	}
	
	public void toStringTest() {
		assertFalse("(1 : class java.lang.Integer, 2 : class java.lang.Integer)"
				.equals(pair.toString()));
	}
}
