<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<h4>Employee Management System</h4>
<div align="right">
<a href="/SpringMVCExample/logout">Logout</a>
</div>
<hr>
<c:forEach var="employee" items="${employeelist}">
	<spring:url value="/profile/{employeeId}" var="employee_url">
		<spring:param name="employeeId" value="${employee.empid}"></spring:param>
	</spring:url>
	<a href="${employee_url}">
		<c:out value="${employee.empname}"></c:out>
		<br>
	</a>
</c:forEach>
<br><br>
<a href="/SpringMVCExample/createEmpPage">Add New Employee</a>
</body>
</html>