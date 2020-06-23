<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update-Order</title>
</head>
<body style="background-color:LightBlue">
<br>
<h2 align="center">Update Order Details</h2>
<form method="post" action="updateOrder">
<br>
            <table align="center" border="1" cellpadding="5" cellspacing="2">

                     <tr>
                        <td style="font-weight: bolder;">Quantity:</td>
                        <td><input type="number" name="quantity" value="${orders.quantity}" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Category:</td>
                        <td><Select name="category">
                        <option>${orders.category}</option>
    <option>Computer</option>
    <option>Flowers</option>
    <option>Pizza</option> 
     <option>Mobile</option> 
    </Select></td>
                    </tr>
                    </table>
                    <br>
                    <center>    
                        <input class="btn btn-success"  type="submit" style="font-weight: bolder;" value="Update Order" />
                            &nbsp;&nbsp;
                            <input class="btn btn-danger" type="reset"  style="font-weight: bolder;"value="Cancel" />
                                             
                </center>
            
        </form> 
</body>
</html>