<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New Role</title>
</head>
<body>
<h4>Register New Role</h4>
<hr>
<form:form method="POST" action="/SpringMVCExample/usermanage/addRole" modelAttribute="role">
   <table>
    <tr>
        <td><form:label path="rolename">Role Name:</form:label></td>
        <td><form:input path="rolename"/></td>
        <td><form:errors path="rolename" cssClass="error" /></td>
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
<hr>
</body>
</html>
