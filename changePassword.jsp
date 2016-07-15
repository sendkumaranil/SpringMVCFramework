<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<title>Change Password</title>
</head>
<body>
<h4>Change Password</h4>
<hr>
<form:form method="POST" id="changePasswordForm" action="/SpringMVCExample/changePwd" modelAttribute="user">
   <table>
    <tr>
        <td><form:label path="username">Enter User Name:</form:label></td>
        <td><form:input path="username" id="txtUserName"/></td>
        <td>${errmsg}</td>
    </tr>
     <tr>
        <td><form:label path="password">Enter New Password:</form:label></td>
        <td><form:password path="password" id="newPassword"/></td>
        <td><form:errors path="password" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="confirmPassword">Confirm Password:</form:label></td>
        <td><form:password path="confirmPassword" id="pwdConfirmed"/></td>
        <td><form:errors path="confirmPassword" cssClass="error" /></td>
    </tr>
    <tr>
    	<td>
    		<div class="g-recaptcha" data-sitekey="6LeZ8yQTAAAAANb641uYZfIK7JdNZseY0U3MOalR"></div>
    	</td>
    </tr>
     <tr>
        <td><input type="submit" value="Save"/>
        <a href="/SpringMVCExample/welcome">Cancel</a></td>
    </tr>
</table>  
</form:form>
<hr>
<script>
  
  // When the browser is ready...
  $(function() {
    // Setup form validation on the #register-form element
    $("#changePasswordForm").validate({
    
        // Specify the validation rules
        rules: {
            username: "required",
            password: "required",
            password: {
                required: true,
                minlength: 5
            },
            confirmPassword:{
            	equalTo:"#newPassword"
            }
        },
        
        // Specify the validation error messages
        messages: {
            username: "Please enter username",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            confirmPassword: "Confirm password doesn't match!!"
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });
  });
 
  </script>
</body>
</html>