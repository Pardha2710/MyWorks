<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Order-Summary</title>
</head>
<body>
<body style="background-color:LightBlue"><br>
<div style="padding: 20px;">
<a class="btn btn-dark" href="back" style="float: left;font-weight: bolder;padding-right: 15px"> Back</a>
<a class="btn btn-danger" href="home" style="float: right;font-weight: bolder;padding-left: 15px"> LogOut</a>
<a  class="btn btn-info" href="view_customer" style="float: right;font-weight: bolder;"> View Profile</a>
</div>
<div style="padding: 30px;">
<h2 align="center">List Of Orders</h2><br>
<table  align="center" cellpadding="10" cellspacing="5">
<tr style="font-weight: bolder;"><th>OrderId</th><th>CustomerID</th><th>ProductID</th><th>Ordered Date</th><th>Order Status</th><th>Amount Paid</th><th>Quantity</th><th>Category</th></tr> 
<c:forEach var="orders" items="${results}">   
   <tr>  
   <td>${orders.orderId}</td>  
   <td>${orders.customerId}</td>  
   <td>${emp.jobTitle}${orders.productId}</td>  
   <td>${orders.orderDate}</td>  
   <td>${orders.status}</td>  
   <td> ${orders.amountPaid}</td>
   <td> ${orders.quantity}</td>
    <td> ${orders.category}</td>
   </tr>  
   </c:forEach> 
</table></div>
<center>
<a class="btn btn-warning" href="update_order">Update Order</a>
<a class="btn btn-danger" href="cancel">Cancel Order</a>
</center>
</body>
</body>
</html>