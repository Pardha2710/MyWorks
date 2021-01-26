<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="beanpack.Student" scope="session"/>
<jsp:setProperty name="student" property="*"/>
<body>
Student Toatl: <jsp:getProperty name="student" property="total"/>
</body>
</html>