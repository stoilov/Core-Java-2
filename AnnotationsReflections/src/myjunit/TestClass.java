package myjunit;

public class TestClass {

	@Before(priority = 1)
	public static void setUp() {
		System.out.println("before1");
	}
	
	@Before(priority = 2)
	public static void setUpAgain() {
		System.out.println("before2");
	}
	
	@Execute
	public static void testAddition() {
		System.out.println("test1");
	}
	
	@Execute
	public static void testSubtraction() {
		System.out.println("test2");
	}
	
	@Execute
	public static void testMultiplication() {
		System.out.println("test3");
	}
	
	@Execute
	public static void testDivision() {
		System.out.println("test4");
	}
	
	@After
	public static void tearDown() {
		System.out.println("after");
	}
	
}
