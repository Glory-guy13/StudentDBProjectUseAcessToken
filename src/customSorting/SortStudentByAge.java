package customSorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByAge implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		return a.getAge()-b.getAge();
	}
	
	

}
