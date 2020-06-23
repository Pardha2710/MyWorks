<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yoga-Registration-Details</title>
</head>
<body>
<hr width="1200px" size="1px" color="black">
<h3 align="center" style="color: Navy;">Welcome <span>${yoga.userName}.</span></h3>
<p style="color: red;">Your registration details are as follows:</p>
<ul>
<li style="font-weight: bolder;color: red;">Email Address: <span style="font-weight: normal;"><a href="mailto:${yoga.emailId}">${yoga.emailId}</a></span></li></br>
<li style="font-weight: bolder;color: red;">Phone Number: <span style="font-weight: normal;">${yoga.contactNumber}</span></li></br>
<li style="font-weight: bolder;color: red;">Gender: <span style="font-weight: normal;">${yoga.gender}</span></li></br>
<li style="font-weight: bolder;color: red;">Age: <span style="font-weight: normal;">${yoga.age}</span></li></br>
<li style="font-weight: bolder;color: red;">Batch: <span style="font-weight: normal;">${yoga.batch}</span></li></br>
<li style="font-weight: bolder;color: red;">Yoga: <span style="font-weight: normal;">
<c:forEach items="${yoga.yogaTypes}" var="lists" varStatus="loop">
        ${lists}
        <c:if test="${!loop.last}">,</c:if>
</c:forEach>
</span>
</li></br>
<li style="font-weight: bolder;color: red;">City: <span style="font-weight: normal;">${yoga.city}</span></li>
</ul>
<h3 style="text-align: center;color: Navy;">Your online registration completed.</br>
Class will be starting soon.</h3>

<hr width="1200px" size="1px" color="black">
</body>
</html>