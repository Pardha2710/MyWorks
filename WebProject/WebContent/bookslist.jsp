<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.*,java.util.*"%>
 <h3>Books List</h3>
 <table align="center" border="1">
<tr>
    <th>Book Title</th>
    <th>Author</th>
    <th>Pages</th>
    <th>No of Copies</th>
    <th>Book Price</th>
    <th>Shelf No</th>
  </tr>
<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java16","root","admin");
	String sql = ("SELECT * FROM books_n;");
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next())
	{%>	
<tr align="center">
   <td><%=rs.getString("booktitle")%></td>
    <td ><%=rs.getString("author") %></td>
    <td><%= rs.getInt("pages") %></td>
    <td><%= rs.getInt("copies")%></td>
    <td><%= rs.getInt("price") %></td>
    <td><%= rs.getInt("shelfno")%></td>
  </tr>
	<% }
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</table>

 