package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import customException.InvalidChoiceException;
import customException.StudentNotFoundException;
import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem{

	Scanner scan = new Scanner(System.in);

	Map<String,Student> db = new LinkedHashMap<String,Student>();


	@Override
	public void addStudent() {
		System.out.println("Enter student age");
		int age = scan.nextInt();
		System.out.println("Enter student name");
		String name = scan.next();
		System.out.println("Enter student marks");
		int marks = scan.nextInt();
		Student s1 = new Student(age, name, marks);
		db.put(s1.getId(), s1);
		System.out.println("Student record inserted successfully");
		System.out.println("Student id : "+s1.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id :");
		String id = scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student s1 = db.get(id);
			System.out.println("Id :\t"+s1.getId());
			System.out.println("Name :\t"+s1.getName());
			System.out.println("Age :\t"+s1.getAge());
			System.out.println("Marks  :\t"+s1.getMarks() );
		}
		else {
			try {
				String msg = "Student with Id "+id+" is not found";
				throw new StudentNotFoundException(msg);
			}
			catch (StudentNotFoundException s) {
				System.out.println(s.getMessage());
			}
		}

	}

	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student records as follows");
			System.out.println("------------------------------------");
			Set<String> keys = db.keySet();
			for (String key : keys) {
				Student std = db.get(key);
				System.out.println(std);
			}
		}
		else {
			try {
				String msg = "Student database is empty, Nothing to display";
				throw new StudentNotFoundException(msg);
			}
			catch (StudentNotFoundException s) {
				System.out.println(s.getMessage());
			}
		}

	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student ID:");
		String id = scan.next();
		id = id.toUpperCase();
		if(db.containsKey(id)) {
			Student s1 = db.get(id);

			System.out.println("1.Update Age\n2.Update Name\n3.Update Marks");
			System.out.println("enter choice");
			int choice = scan.nextInt();

			switch(choice) {
			case 1: 
				System.out.println("Enter age for update:");
				int age = scan.nextInt();
				s1.setAge(age);
				System.out.println("Age updated successfully");
				break;

			case 2: 
				System.out.println("Enter name for update");
				String name= scan.next();
				s1.setName(name);
				System.out.println("Name updated successfully");
				break;

			case 3: 
				System.out.println("Enter marks for update");
				int marks =scan.nextInt();
				s1.setMarks(marks);
				System.out.println("Marks updated successfully");
				break;

			default :
				try {
					throw new InvalidChoiceException("Kindly enter invalid option");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="Student with "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeStudent() {
		System.out.println("Enter student id : ");
		String id = scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student record is");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record deleted succesfully");
		}
		else {

			try {
				String msg = "Student with the id "+id+" is removed";
				throw new StudentNotFoundException(msg);
			}
			catch (StudentNotFoundException s) {
				System.out.println(s.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents() {
		if(db.size()!=0) {
			System.out.println("Available student records "+db.size());
			db.clear();
			System.out.println("All the student records deleted succesfully");
		}
		else {

			try {
				String msg = "Student database is empty, Nothing to delete";
				throw new StudentNotFoundException(msg);
			}
			catch (StudentNotFoundException s) {
				System.out.println(s.getMessage());
			}
		}

	}

	@Override
	public void countStudents() {
		System.out.println("No of Students: "+db.size());

	}

	@Override
	public void sortStudents() {
		if(db.size()>=2) {
			Set <String> keys = db.keySet();
			List<Student> list = new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(key));
			}

			System.out.println("Enter your option\n1:Sort Student By Id\n2:Sort Student By Age\n3:Sort Student By Name\n4:Sort Student By Marks");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				Collections.sort(list , new SortStudentById());
				display(list);
				break;
			case 2:
				Collections.sort(list, new SortStudentByAge());
				display(list);
				break;
			case 3:
				Collections.sort(list , new SortStudentByName());
				display(list);
				break;
			case 4:
				Collections.sort(list , new SortStudentByMarks());
				display(list);
				break;
			default:
				try {
					String msg = "Enter valid choice";
					throw new InvalidChoiceException(msg);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String msg = "No suffient data for sort";
				throw new StudentNotFoundException(msg);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}

	//to reduce redundancy we use display() this method
	private static void display(List<Student> list){
		for (Student s : list) {
			System.out.println(s);
		}
	}


	@Override
	public void getStudentsHighestMarks() {
		if(db.size()>=2) {
			Set<String> keys =db.keySet();
			List<Student> list = new ArrayList<Student>();
			for (String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list , new SortStudentByMarks());
			System.out.println(list.get(db.size()-1));
		}
		else {
			try {
				String s = "No Sufficient record";
				throw new StudentNotFoundException(s);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentsLowestMarks() {
		if(db.size()>=2) {
			Set<String> keys =db.keySet();
			List<Student> list = new ArrayList<Student>();
			for (String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list , new SortStudentByMarks());
			System.out.println(list.get(0));
		}
		else {
			try {
				String s = "No Sufficient record";
				throw new StudentNotFoundException(s);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
