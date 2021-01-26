<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
	try
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java16","root","admin");
		String sql = ("SELECT * FROM admin WHERE username='" + username + "' AND password='" + password + "';");
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next())
				response.sendRedirect("Menu.jsp");
		else
			out.println("Invalid login credentials");
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
%>