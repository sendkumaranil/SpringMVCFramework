<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Profile</title>
</head>
<body>
<table border="1" width="50%">
	<tr align="left">
		<th nowrap="nowrap" align="left">Employee Id</th>
		<th nowrap="nowrap" align="left">Employee Name</th>
		<th nowrap="nowrap" align="left">Date of Birth</th>
		<th nowrap="nowrap" align="left">Date of Joining</th>
		<th nowrap="nowrap" align="left">Email</th>
		<th nowrap="nowrap" align="left">Mobile No</th>
		<th nowrap="nowrap" align="left">ID type</th>
		<th nowrap="nowrap" align="left">ID No</th>
	</tr>
	<tr align="left">
		<td nowrap="nowrap" align="left">${emp_profile.empid}</td>
		<td nowrap="nowrap" align="left">${emp_profile.empname}</td>
		<td nowrap="nowrap" align="left">${emp_profile.dob}</td>
		<td nowrap="nowrap" align="left">${emp_profile.doj}</td>
		<td nowrap="nowrap" align="left">${emp_profile.emailid}</td>
		<td nowrap="nowrap" align="left">${emp_profile.mobileno}</td>
		<td nowrap="nowrap" align="left">${emp_profile.idtype}</td>
		<td nowrap="nowrap" align="left">${emp_profile.idno}</td>
	</tr>
</table>

<div  align="left">
<span>
	<spring:url value="/profile/edit/{employeeId}" var="employee_url">
		<spring:param name="employeeId" value="${emp_profile.empid}"></spring:param>
	</spring:url>
	<a href="${employee_url}">
		<c:out value="Edit"></c:out>
	</a>|
	<spring:url value="/profile/delete/{employeeId}" var="employee_delete_url">
		<spring:param name="employeeId" value="${emp_profile.empid}"></spring:param>
	</spring:url>
	<a href="${employee_delete_url}">
		<c:out value="Delete"></c:out>
	</a>
</span>
</div>
<br><br>
<a href="/SpringMVCExample/welcome">Back</a>
</body>
<script type="text/javascript">

</script>
</html>
