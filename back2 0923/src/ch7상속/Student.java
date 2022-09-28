package ch7상속;

public class Student extends People {
	int studentNo;
	
	public Student( String name, String ssn , int studentNo){
		super(name , ssn);
		this.studentNo = studentNo;
	}
}
