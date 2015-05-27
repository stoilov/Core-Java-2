package task1;

import java.lang.annotation.Annotation;

public class InstantiateRectangle {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		Annotation[] myAnnotations = rectangle.getClass().getAnnotations();

		for (Annotation annotation : myAnnotations) {
			System.out.printf("Annotation: %s\n\n", annotation);
		}

		Annotation myAnnotation = rectangle.getClass().getAnnotation(
				ClassInfo.class);

		System.out.printf("Author: %s\n", ((ClassInfo) myAnnotation).author());
		System.out.printf("Revision: %s\n",
				((ClassInfo) myAnnotation).revision());
		System.out
				.printf("Checked: %s\n", ((ClassInfo) myAnnotation).checked());

		Object[] related = ((ClassInfo) myAnnotation).related();
		for (Object object : related) {
			System.out.printf("Related class: %s\n", object);
		}
	}

}
