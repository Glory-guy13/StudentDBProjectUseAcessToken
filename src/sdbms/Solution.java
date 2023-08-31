package sdbms;

import java.util.Scanner;

import customException.InvalidChoiceException;



public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StudentManagementSystem sms = (StudentManagementSystem)new StudentManagementSystemImpl();
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("Enter your choice");
			System.out.println("1.Add Student\n2.Display Student\n3.Display All Student\n4.Update Student\n5.Remove Student\n6.Remove All Students\n7.Count Students\n8.Sort Students\n9.Get Students Highest Marks\n10.Get Students Lowest Marks\n11.Exit");
			int choice = s.nextInt();
			switch(choice) {
			case 1: 
				sms.addStudent();
				break;

			case 2: 
				sms.displayStudent();
				break;

			case 3:
				sms.displayAllStudent();
				break;

			case 4:
				sms.updateStudent();
				break;

			case 5:
				sms.removeStudent();
				break;

			case 6: 
				sms.removeAllStudents();
				break;

			case 7:
				sms.countStudents();
				break;

			case 8:
				sms.sortStudents();
				break;

			case 9:
				sms.getStudentsHighestMarks();
				break;

			case 10:
				sms.getStudentsLowestMarks();
				break;

			case 11:
				System.out.println("Thank you, visit Again");
				System.exit(0);

			default:
				try {
					throw new InvalidChoiceException("Invalid choice, Kindly enter valid choice");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
