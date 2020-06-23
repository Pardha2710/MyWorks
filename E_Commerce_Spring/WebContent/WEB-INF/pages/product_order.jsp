<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Product Ordering</title>
</head>
<body style="background-color:LightBlue">
<br>
<div class="btn-toolbar" style="padding-right: 15px;float: right;">
<a  class="btn btn-info" href="view_customer" style="float: right;font-weight: bolder;"> View Profile</a>
<a  class="btn btn-danger" href="home" style="float: right;font-weight: bolder;padding-left: 15px;"> LogOut</a>
        </div>
        <div style="padding: 30px;">

<table  align="center" cellpadding="10" cellspacing="5">
<thead><tr><td><h1>List of Products</h1></td></tr></thead>
<tr style="font-weight: bolder;"><th>ProductId</th><th>ProductName</th><th>Price</th><th>Category</th></tr> 
<c:forEach var="products" items="${productsList}">   
   <tr>  
   <td>${products.productId}</td>  
   <td>${products.productName}</td>  
   <td> <fmt:formatNumber value="${products.price}" type="currency"/></td>
    <td>${products.category}</td>
   </tr>  
   </c:forEach> 
</table></div>
<center>
<form action="product"  method="POST">
Enter a Product Id To Order: <input type="number" name="productId" required /> 
<input type="submit" value="Proceed"/>
<input type="reset" value="Cancel"/>
</form>
</center>
    </body>
</html>