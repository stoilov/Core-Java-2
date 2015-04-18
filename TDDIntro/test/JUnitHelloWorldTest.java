import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JUnitHelloWorldTest {
	private JUnitHelloWorld helloWorld;

	@Before
	public void setUp() {
		this.helloWorld = new JUnitHelloWorld();
	}

	@Test
	public void getNumberOfDigitsTest() {
		assertEquals(1, helloWorld.getNumberOfDigits(1));
		assertEquals(2, helloWorld.getNumberOfDigits(21));
		assertEquals(3, helloWorld.getNumberOfDigits(-123));
		assertEquals(3, helloWorld.getNumberOfDigits(100));
	}
}
