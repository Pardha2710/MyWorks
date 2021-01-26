package beanpack;

public class Student {
	
	private int rollno;
	private String sname;
	private int mark1,mark2,mark3,total;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public int getMark3() {
		return mark3;
	}
	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	public int getTotal() {
		return mark1+mark2+mark3;
	}
	public void setTotal(int total) {
		this.total = mark1+mark2+mark3;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", mark1=" + mark1 + ", mark2=" + mark2 + ", mark3="
				+ mark3 + ", total=" + total + "]";
	}
	
	

}
