package myjunit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyJUnit {

	public Annotation getMyJUnitAnnotations(Method method) {
		Annotation[] myAnnotations = method.getDeclaredAnnotations();

		for (Annotation annotation : myAnnotations) {
			if (annotation instanceof Before || annotation instanceof Execute
					|| annotation instanceof After) {
				return annotation;
			}
		}

		return null;
	}

	public Method[] getMyJUnitMethods(Class<?> aClass)
			throws ClassNotFoundException {
		Method[] methods = aClass.getMethods();

		return methods;
	}

	public Object getObjectInstance(Class<?> aClass)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<?>[] constructors = aClass.getDeclaredConstructors();
		Constructor<?> constructor = null;

		for (int i = 0; i < constructors.length; i++) {
			constructor = constructors[i];
			if (constructor.getGenericParameterTypes().length == 0) {
				break;
			}
		}

		constructor.setAccessible(true);
		Object object = constructor.newInstance();

		return object;
	}

	public void runTest(Class<?> aClass) throws ClassNotFoundException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException {

		Object object = getObjectInstance(aClass);

		List<Method> executes = new ArrayList<Method>();
		Map<Before, Method> befores = new TreeMap<Before, Method>(
				new BeforeComparator());
		Method[] methods;
		methods = getMyJUnitMethods(aClass);
		Method after = null;

		for (Method method : methods) {
			Annotation annotation = getMyJUnitAnnotations(method);

			if (annotation instanceof Before) {
				befores.put((Before) annotation, method);
			}
			if (annotation instanceof After) {
				after = method;
			}
			if (annotation instanceof Execute) {
				executes.add(method);
			}
		}

		for (Method test : executes) {
			for (Method method : befores.values()) {
				method.invoke(object);
			}
			test.invoke(object);
			after.invoke(object);
		}
	}
}
