package myjunit;

import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException {

		Class<?> testClass = TestClass.class;
		MyJUnit unit = new MyJUnit();
		unit.runTest(testClass);
	}

}
