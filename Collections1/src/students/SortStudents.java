package students;

import java.util.ArrayList;
import java.util.Arrays;

public class SortStudents {
	
	public static void sort(ArrayList<Student> students) {
		students.sort(Student.StudentComparator);
	}
	
	public static void main(String[] args) {
		Student student1 = new Student("Angel", 5);
		Student student2 = new Student("Boiko", 6);
		Student student3 = new Student("Ivan", 2);
		Student student4 = new Student("Boris", 2);
		Student student5 = new Student("Pesho", 3);
		
		ArrayList<Student> students = new ArrayList<Student>(
				Arrays.asList(student1, student2, student3, student4, student5));
		
		System.out.println(students);
		sort(students);
		System.out.println(students);
	}
	
}
