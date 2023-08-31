package customSorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByMarks implements Comparator<Student>{

	@Override
	public int compare(Student a, Student b) {
		return a.getMarks()-b.getMarks();
	}

}
