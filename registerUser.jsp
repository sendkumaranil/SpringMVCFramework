<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New User</title>
</head>
<body>
<h4>Register New User</h4>
<hr>
<form:form method="POST" action="/SpringMVCExample/usermanage/addUser" modelAttribute="user">
   <table>
    <tr>
        <td><form:label path="username">User Name:</form:label></td>
        <td><form:input path="username"/></td>
        <td><form:errors path="username" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password:</form:label></td>
        <td><form:password path="password" /></td>
        <td><form:errors path="password" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="emailid">Email:</form:label></td>
        <td><form:input path="emailid" /></td>
        <td><form:errors path="emailid" cssClass="error" /></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Submit"/>
        </td>
        <td>
        	<a href="/SpringMVCExample/usermanage/register">Cancel</a>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>