import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PairTestIntegersAndStrings {

	private Pair pair;

	@Before
	public void setUp() {
		String hello = "Hello";
		Integer one = 1;
		this.pair = new Pair(hello, one);
	}

	@Test
	public void equalsTest() {
		String hello2 = "Hello";
		Integer one2 = 1;
		Pair pair2 = new Pair(hello2, one2);
		assertTrue(pair.equals(pair2));
		Pair pair3 = new Pair(one2, hello2);
		assertFalse(pair.equals(pair3));
	}
	
	public void toStringTest() {
		assertTrue("(Hello : class java.lang.String, 1 : class java.lang.Integer)"
				.equals(pair.toString()));
	}
}
