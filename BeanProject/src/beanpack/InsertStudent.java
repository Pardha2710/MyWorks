package beanpack;
import java.sql.*;
public class InsertStudent {
	
	public static boolean saveStudent(Student student)
	{
		int n=0;
		int rollno=student.getRollno();
		String sname=student.getSname();
		int mark1=student.getMark1();
		int mark2=student.getMark2();
		int mark3=student.getMark3();
		int total=student.getTotal();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java16","root","admin");
			PreparedStatement st=con.prepareStatement("insert into Student(rollno,sname,mark1,mark2,mark3,total) values('"+rollno+"','"+sname+"','"+mark1+"','"+mark2+"','"+mark3+"','"+total+"')");
			n=st.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(n==1)
			return true;
		else
			return false;
		
	}

}
