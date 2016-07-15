<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Users and Roles</title>
</head>
<body>
<h4>Roles assigned to users details:</h4>
<hr>
<div class="container">
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Username</th>
        <th>Role</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${mappedUsers}" var="mappedusers" >
      <tr>
        <td><c:out value="${mappedusers.username}"></c:out></td>
        <td><c:out value="${mappedusers.rolename}"></c:out></td>
        <td><c:out value="${mappedusers.useremailid}"></c:out></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<hr>
<a href="/SpringMVCExample/welcome">Back</a>
</body>
</html>