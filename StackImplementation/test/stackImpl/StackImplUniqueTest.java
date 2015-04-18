package stackImpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackImplUniqueTest {

	private StackImplUnique stack;

	@Before
	public void setUp() {
		this.stack = new StackImplUnique(10);
		Integer one = 1;
		String oneStr = "one";
		stack.push(one);
		stack.push(oneStr);
	}

	@Test
	public void pushTest() {
		assertEquals("one",  stack.pop());
		assertEquals(1, stack.pop());
	}
	
	@Test
	public void pushNonRepeatingElementTest() {
		assertTrue(stack.push("two"));
	}
	
	@Test
	public void pushRepeatingElementTest() {
		assertFalse(stack.push(1));
		assertEquals("one", stack.pop());
	}

}
