<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>YogaRegistration</title>

</head>
<body>

<h1 align="center">Yoga Class Registration</h1>
<hr width="500px" size="1px" color="peru"></br>
<form action="${pageContext.request.contextPath}/register.html" method="post">
<table align="center">
<tr>
<td>
 <input style="border-width: 1px ;border-color: tan;font-size: 15pt" type="text" name="userName" placeholder="Your Name" required="required"/>
</br></br>
</td>
</tr>
<tr>
<td>
<input style="border-width: 1px ;border-color: tan;font-size: 15pt" type="email" name="emailId" placeholder="Email Id" required="required"/>
</br></br>
</td></tr>
<tr>
<td>
<input style="border-width: 1px ;border-color: tan;font-size: 15pt" type="number" name="contactNumber" placeholder="Contact Number" required="required"/>
</br></br>
</td></tr>
<tr><td style="font-weight: bold;" >
Gender:</td><tr>

<td>
<input style="border-color: tan;" type="radio" name="gender" value="Male" required="required">Male</td>
</tr>
<tr>
<td>

<input style="border-color: tan;" type="radio" name="gender" value="Female" required="required">Female</td>

</tr>

<tr><td></br>
<input style="border-width: 1px ;border-color: tan;font-size: 15pt" type="number" name="age" placeholder="Age" required="required"/></td></tr>
<tr><td style="font-weight: bold;"></br>
Batch That fits your timing!</td></tr>
<tr><td>
<input style="border-color: tan;" type="radio" name="batch" value="Morning: 6:30 to 8:30" required="required">Morning: 6:30 to 8:30</td></tr>
<tr><td>
<input style="border-color: tan;" type="radio" name="batch" value="Morning: 8:30 to 10:30" required="required">Morning: 8:30 to 10:30</td></tr>
<tr><td>
<input style="border-color: tan;" type="radio" name="batch" value="Evening: 4:30 to 6:30" required="required">Evening: 4:30 to 6:30</td></tr>
<tr><td>
<input style="border-color: tan;" type="radio" name="batch" value="Evening: 6:30 to 8:30" required="required">Evening: 6:30 to 8:30</td></tr>
<tr><td style="font-weight: bold;"></br>
Yoga you want to register for!
</tr></td>
<tr><td>
<input style="border-color: tan;" type="checkbox" name="yogaTypes" value="Anusara">Anusara</tr></td>
<tr><td>
<input style="border-color: tan;" type="checkbox" name="yogaTypes" value="Ashtanga">Ashtanga</tr></td>
<tr><td>
<input style="border-color: tan;" type="checkbox" name="yogaTypes" value="Bikram">Bikram</tr></td>
<tr><td>
<input style="border-color: tan;" type="checkbox" name="yogaTypes" value="Power">Power</tr></td>
<tr><td>
<input style="border-color: tan;" type="checkbox" name="yogaTypes" value="Jivamukti">Jivamukti</tr></td>
<tr><td>
<input style="border-color: tan;" type="checkbox" name="yogaTypes" value="Kundlini" required="required">Kundlini</tr></td>

<tr><td></br>
<input style="border-width: 1px ;border-color: tan;font-size: 15pt" type="text" name="city" placeholder="City" required="required"></tr></td>

<tr><td align="center"></br>
<input  type="submit" value="Confirm Registration!" style="background-color: peru;color: black;font-weight: bold;font-size: 15pt"></tr></td>

</table>
</form>
 
</body>
</html>