<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>UpdateUser</title>
</head>
<body style="background-color:LightBlue">
<br>
<h2 align="center">Update User Details</h2>
<form method="post" action="update_customer">
<br>
            <table align="center" border="1" cellpadding="5" cellspacing="2">
              
                    <tr>
                        <td style="font-weight: bolder;">UserName:</td>
                        <td><input type="text" name="userName" value="${customers.userName}" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Password:</td>
                        <td><input type="password" name="password" value="${customers.password}" required/></td>
                    </tr>
                     <tr>
                        <td style="font-weight: bolder;">First Name:</td>
                        <td><input type="text" name="firstname" value="${customers.firstname}" required/></td>
                    </tr>
                     <tr>
                        <td style="font-weight: bolder;">Last Name:</td>
                        <td><input type="text" name="lastname" value="${customers.lastname}" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Address:</td>
                        <td><input type="text" name="address" value="${customers.address}" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">City:</td>
                        <td><input type="text" name="city" value="${customers.city}"required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Postal Code:</td>
                        <td><input type="text" name="postalCode" value="${customers.postalCode}" required/></td>
                    </tr></table>
                    <br>
                    <center>    
                        <input class="btn btn-success"  type="submit" style="font-weight: bolder;" value="Update Customer" />
                            &nbsp;&nbsp;
                            <input class="btn btn-danger" type="reset"  style="font-weight: bolder;"value="Cancel" />
                                             
                </center>
            
        </form> 
</body>
</html>