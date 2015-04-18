import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DoublyLinkedListTest {

	private List doublyLinked;

	@Before
	public void setUp() {
		this.doublyLinked = new List();
		doublyLinked.add(1);
		doublyLinked.add(2);
		doublyLinked.add(3);
	}
	
	@Test
	public void addTest() {
		assertEquals(3, doublyLinked.getTail());
	}
	
	@Test
	public void removeFromTailTest() {
		assertEquals(3, doublyLinked.remove(2));
		assertEquals(2, doublyLinked.getTail());
	}
	
	@Test
	public void removeFromHeadTest() {
		assertEquals(1, doublyLinked.remove(0));
		assertEquals(3, doublyLinked.getTail());
		assertEquals(2, doublyLinked.getHead());
	}
	
	@Test
	public void removeFromMiddleTest() {
		assertEquals(2, doublyLinked.remove(1));
		assertEquals(3, doublyLinked.getTail());
		assertEquals(1, doublyLinked.getHead());
	}
	
	@Test
	public void sizeTest() {
		assertEquals(3, doublyLinked.size());
	}
	
	@Test
	public void getTest() {
		assertEquals(2, doublyLinked.get(1));
	}

}
