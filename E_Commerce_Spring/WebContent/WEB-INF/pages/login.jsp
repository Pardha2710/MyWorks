<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body style="background-color:LightBlue;" >
        <form method="post" action="login">
          <br><br>
            <table align="center" cellpadding="10" cellspacing="5">
                
                    <tr>
  
                        <td><input type="text" name="username" placeholder="UserName" required/></td>
                    </tr>
                    <tr>
                       
                        <td><input type="password" name="password"  placeholder="password" required/></td>
                    </tr>
                    <tr align="center">
                       <td colspan="2" > <button type="submit" style="font-weight: bolder;" class="btn btn-success">Login</button>
                           
                        </td>                        
                    </tr>                    
                
            </table>   
        </form><br>
	<center><button type="button" style="font-weight: bolder;"  class="btn btn-light"><a href="add_customer.jsp" align="center">SignUp Here!</a></button></center>
</body>
    </html>