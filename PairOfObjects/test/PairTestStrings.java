import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PairTestStrings {
	private Pair pair;

	@Before
	public void setUp() {
		String hello = "Hello";
		String world = "World";
		this.pair = new Pair(hello, world);
	}
	
	@Test
	public void equalsTest() {
		String hello2 = "Hello";
		String world2 = "World";
		Pair pair2 = new Pair(hello2, world2);
		assertTrue(pair.equals(pair2));
	}
	
	public void toStringTest() {
		assertTrue("(Hello : class java.lang.String, World : class java.lang.String)"
				.equals(pair.toString()));
	}
}
