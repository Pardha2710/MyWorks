import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddbookServlet extends HttpServlet {
	Connection con;
	PrintWriter out;
	PreparedStatement pre;
	public void init(ServletConfig config)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java16","root","admin");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		out=response.getWriter();
		response.setContentType("text/html");
		String bNo=request.getParameter("bookNo");
		String bName = request.getParameter("bookName");
		String auth=request.getParameter("author");
		String price=request.getParameter("price");
		String value=request.getParameter("action");
		if(value.equals("Add Book"))
		{
			try
			{
				
				pre=con.prepareStatement("insert into Books values('"+bNo+"','"+bName+"','"+auth+"','"+price+"')");
				pre.executeUpdate();
				out.println("Inserted Successfully");
				out.println();
				out.println("<a href=\"addbook.html\">Menu</a>");
				
			}catch (Exception e) {
				out.println(e);
			}
		}
		else if(value.equals("List Books"))
		{
			try {
				pre=con.prepareStatement("select * from Books");
				ResultSet rs=pre.executeQuery();
			    out.println("<h1>Books List</h1>");  
				out.println("<table border=1 width=50% height=50%>");  
	            out.println("<tr><th>BookNo</th><th>BookName</th><th>Author</th><th>Price</th><tr>");  
	            while (rs.next()) 
	            {  
	                String bno = rs.getString("BookNo"); 
	                String bnm = rs.getString("BookName");  
	                String aut=rs.getString("Author");
	                String pr=rs.getString("Price");  
	                out.println("<tr align=\"center\"><td>" + bno + "</td><td>" + bnm + "</td><td>" + aut + "</td><td>"+"Rs "+pr+"</td></tr>");   
	            }  
	            out.println("</table><br>");  
	            out.println("<a href=\"addbook.html\">Add New Book</a>");   
			} catch (Exception e) {
				out.println(e);
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy()
	{
		try {
			con.close();
			pre.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
