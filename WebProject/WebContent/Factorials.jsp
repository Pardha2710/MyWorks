<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Factorial</title>
</head>
<body>
<%!
int fact(int n){
	if(n==0 || n==1)
		return 1;
	else
		return n*fact(n-1);
}
%>
<%
for(int i=1;i<=5;i++)
{
	out.println("Factorial("+i+"):"+fact(i)+"<br/>");
}
%>
</html>