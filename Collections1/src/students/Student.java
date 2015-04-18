package students;

import java.util.Comparator;

public class Student {

	private String name;
	private int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public String toString() {
		return String.format("%d %s", grade, name);
	}
	
	public static Comparator<Student> StudentComparator = new Comparator<Student>() {

		public int compare(Student student1, Student student2) {
			return student1.toString().compareTo(student2.toString());
		}

	};

}
