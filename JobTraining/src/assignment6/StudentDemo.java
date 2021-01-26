package assignment6;

class Student
{
	int rollNum;
	String studName;
	double mark1,mark2,mark3,totalMarks;
	
	void setStudDeatils(int rollNum,String studName,double mark1,double mark2, double mark3)
	{
		this.rollNum=rollNum;
		this.studName=studName;
		this.mark1=mark1;
		this.mark2=mark2;
		this.mark3=mark3;
	}
	void calculateToatl()
	{
		totalMarks=mark1+mark2+mark3;
	}
	void displayStudDetails()
	{
		System.out.println("Roll Number:"+rollNum+"\n"+"Student Name:"+studName+"\n"+"Total Marks:"+totalMarks);
	}
	
}

public class StudentDemo {

	public static void main(String[] args) {
		
		Student s=new Student();
		s.setStudDeatils(100, "PARDHU", 79, 85, 91);
		s.calculateToatl();
		s.displayStudDetails();
	}

}
