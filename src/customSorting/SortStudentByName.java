package customSorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByName  implements Comparator<Student>{

	@Override
	public int compare(Student a, Student b) {
		
		return a.getName().compareTo(b.getName());
	}

}
