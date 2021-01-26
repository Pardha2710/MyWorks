<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java16","root","admin");
	String title=request.getParameter("booktitle");
	String auth = request.getParameter("author");
	int pages=Integer.parseInt(request.getParameter("pages"));
	int copies=Integer.parseInt(request.getParameter("copies"));
	int price=Integer.parseInt(request.getParameter("price"));
	int shelfno=Integer.parseInt(request.getParameter("shelfno"));
	Statement st=con.createStatement();
	int i=st.executeUpdate("insert into books_n(booktitle,author,pages,copies,price,shelfno) values('"+title+"','"+auth+"','"+pages+"','"+copies+"','"+price+"','"+shelfno+"')");
	out.println("Inserted Successfully");%>
	<br>
	<a href="Menu.jsp">Menu</a>
	<%
}
catch(Exception e)
{
	e.printStackTrace();
}

%>