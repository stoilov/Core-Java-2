package stackImpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {

	private StackImpl stack;

	@Before
	public void setUp() {
		this.stack = new StackImpl(10);
		Integer one = 1;
		String oneStr = "one";
		stack.push(one);
		stack.push(oneStr);
	}
	
	@Test
	public void pushTest() {
		assertTrue(stack.push("one"));
		assertTrue(stack.push("two"));
	}

	@Test
	public void pushAndPopTest() {
		assertTrue("one".equals(stack.pop()));
		assertEquals(1, stack.pop());
	}

	@Test
	public void lengthTest() {
		assertEquals(2, stack.length());
	}

	@Test
	public void clearTest() {
		stack.clear();
		assertEquals(0, stack.length());

		stack.push("hello");

		assertEquals(1, stack.length());
		assertTrue("hello".equals(stack.pop()));
		assertEquals(0, stack.length());
	}

	@Test
	public void isEmptyTest() {
		assertFalse(stack.isEmpty());

		stack.clear();
		assertTrue(stack.isEmpty());

		StackImpl anotherStack = new StackImpl(10);
		assertTrue(anotherStack.isEmpty());
	}

}
