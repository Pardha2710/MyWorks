<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>AddCustomer</title>
</head>
<body style="background-color:LightBlue">
<br>
<h2 align="center">SignUp Details</h2>
<form method="post" action="add_customer">
<br>
            <table align="center" border="1" cellpadding="5" cellspacing="2">
              
                    <tr>
                        <td style="font-weight: bolder;">UserName:</td>
                        <td><input type="text" name="userName" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Password:</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                     <tr>
                        <td style="font-weight: bolder;">First Name:</td>
                        <td><input type="text" name="firstname" required/></td>
                    </tr>
                     <tr>
                        <td style="font-weight: bolder;">Last Name:</td>
                        <td><input type="text" name="lastname" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Address:</td>
                        <td><input type="text" name="address" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">City:</td>
                        <td><input type="text" name="city" required/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Postal Code:</td>
                        <td><input type="text" name="postalCode" required/></td>
                    </tr></table>
                    <br>
                    <center>    
                        <input class="btn btn-success"  type="submit" style="font-weight: bolder;" value="Add Customer" />
                            &nbsp;&nbsp;
                            <input class="btn btn-danger" type="reset"  style="font-weight: bolder;"value="Cancel" />
                                             
                </center>
            
        </form> 
</body>
</html>