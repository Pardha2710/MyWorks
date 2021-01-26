package jdbc;
import java.sql.*;
public class JdbcStatementDemo {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement st = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java16","root","admin");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while (rs.next())
			{
				System.out.println(rs.getInt("eid")+" "+rs.getString("ename")+" "+rs.getFloat(3));//3 is column no(salary)
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			st.close();
			con.close();
		}
	}

}
