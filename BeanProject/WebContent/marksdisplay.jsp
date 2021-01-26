<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource var="dataSource" 
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://127.0.0.1:3306/java16"
	user="root" password="admin"/>
	
<body>
<center>
<h3>Student Marks Records</h3>
<sql:query var="students" dataSource="${dataSource}">
	select * from Student
</sql:query>
<table border>
	<tr>
		<th>Roll No</th>
		<th>Student Name</th>
		<th>Mark1</th>
		<th>Mark2</th>
		<th>Mark3</th>
		<th>Total</th>
	</tr>
	<c:forEach var="student" items="${students.rows}">
		<tr>
			<td><c:out value="${student.rollNo}"></c:out></td>
			<td><c:out value="${student.sname}"></c:out></td>
			<td><c:out value="${student.mark1}"></c:out></td>
			<td><c:out value="${student.mark2}"></c:out></td>
			<td><c:out value="${student.mark3}"></c:out></td>
			<td><c:out value="${student.total}"></c:out></td>
		</tr>
	</c:forEach>
</table><br>
<b></b><a href="menu.jsp">Main Menu</a></b>
</center>

</body>