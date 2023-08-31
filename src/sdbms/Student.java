package sdbms;

public class Student {

	private String id;
	private int age;
	private String name;
	private int marks;

	static int count=101;
	int a=18;
	int b=4;
	public Student(int age, String name, int marks) {
		this.id = b+"CA"+a+"ME"+count++;
		this.age = age;
		this.name = name;
		this.marks = marks;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
	}
	
}
