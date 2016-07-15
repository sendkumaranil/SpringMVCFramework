<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignIn</title>
<style>
.error {
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>
</head>
<body>
<h4>SignIn</h4>
<hr>
<div>
    <c:url var="loginUrl" value="/j_spring_security_check"></c:url>
    	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
    <form action="${loginUrl}" method="POST">
        <table>
            <tr>
                <td>User ID:</td>
                <td><input type='text' name='j_username' /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                    value="Login" /></td>
            </tr>
        </table>
    </form>
    <p><a href="/SpringMVCExample/forgetPassword">Forget password</a>|
    <a href="/SpringMVCExample/">Home</a></p>
    
</div>
    <hr>
</body>
</html>