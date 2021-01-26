<%@page import="beanpack.InsertStudent" %>
<jsp:useBean id="student" class="beanpack.Student" scope="session"/>
<jsp:setProperty name="student" property="*"/>
<%
 	boolean flag=InsertStudent.saveStudent(student);
	if(flag)
		out.println("Student Marks Added Successfully!");
%>
<br>
<a href="menu.jsp">Student Menu</a>