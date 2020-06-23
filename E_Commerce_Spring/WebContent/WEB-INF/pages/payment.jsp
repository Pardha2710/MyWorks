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
<title>Checkout-Page</title>
</head>
<body style="background-color:LightBlue">
<div style="padding: 20px;">
<a class="btn btn-dark" href="back" style="float: left;font-weight: bolder;padding-right: 15px"> Back</a>
<a  class="btn btn-info" href="view_customer" style="float: right;font-weight: bolder;"> View Profile</a>
<a class="btn btn-danger" href="home" style="float: right;font-weight: bolder;padding-left: 15px"> LogOut</a>
</div>
<br>
<h1 align="center">Checkout Details</h1><br>
<form action="order" method="POST">
<table align="center" cellpadding="10" cellspacing="10">
<tr>
<td style="font-weight: bolder;">ProductId:</td>
<td><input type="number" value="${products.productId}" name="productId" readonly="readonly"/></td>
</tr>
<tr><td style="font-weight: bolder;">
Amount Need To Pay:
</td>
<td> <input type="text" value="<fmt:formatNumber value="${products.price}" type="currency"/>" name="amountPaid" readonly="readonly"></td>
</tr>
<tr><td style="font-weight: bolder;">
Number Of Items:
</td>
<td><input type="number" name="quantity" required/></td>
</tr>
<tr><td style="font-weight: bolder;">
Type of Product:
</td>
<td><input type="text" value="${products.category}" name="category" readonly="readonly"/></td>
</tr>
<tr>
 <td style="font-weight: bolder;">
 Payment Method:</td><td>
 <ul>
 <li><input type="radio" name="cardType" value="Master Card">Master Card</li>
<li><input type="radio" name="cardType" value="Visa Card">Visa Card</li>
<li><input type="radio" name="cardType" value="American Express">American Express</li>
 </ul>
 </td>
 </tr>
</table><br>
<center>
<input class="btn btn-success" type="submit" value="Pay and Place Order"/>&nbsp;&nbsp;
<input class="btn btn-danger" type="reset" value="Cancel"/>
</center>
</form>
</body>
</html>