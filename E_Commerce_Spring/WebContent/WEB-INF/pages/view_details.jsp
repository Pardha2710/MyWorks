<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>User Data</title>
</head>
<body style="background-color:LightBlue"><br>
<div style="padding: 20px;">
<a class="btn btn-dark" href="back" style="float: left;font-weight: bolder;padding-right: 15px"> Back</a>
<a class="btn btn-danger" href="home" style="float: right;font-weight: bolder;padding-left: 15px"> LogOut</a>
</div>
<div style="padding: 30px;">
<h1 align="center">User Details</h1><br>
<table  align="center" cellpadding="10" cellspacing="5">
<tr>
<td style="font-weight: bolder;font-size: 15pt;">Customer ID: &nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="font-size: 12pt;">${customers.customerId}</td>
</tr>
<tr>
<td style="font-weight: bolder;font-size: 15pt;">UserName: &nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="font-size: 12pt;">${customers.userName}</td>
</tr>
<tr>
<td style="font-weight: bolder;font-size: 15pt;">FirstName: &nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="font-size: 12pt;">${customers.firstname}</td>
</tr>
<tr>
<td style="font-weight: bolder;font-size: 15pt;">LastName:&nbsp;&nbsp;&nbsp;&nbsp;
<td style="font-size: 12pt;">${customers.address}</td>
</tr>
<tr>
<td style="font-weight: bolder;font-size: 15pt;">City: &nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="font-size: 12pt;">${customers.city}</td>
</tr>
<tr>
<td style="font-weight: bolder;font-size: 15pt;">Postal Code: &nbsp;&nbsp;&nbsp;&nbsp;</td>
 <td style="font-size: 12pt;">${customers.postalCode}</td>
 </tr>
</table></div>
<center>
<a  class="btn btn-warning" href="update" style="font-weight: bolder;">Update User Details</a>
</center>
</body>
</html>