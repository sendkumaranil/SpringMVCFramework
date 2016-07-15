<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<title>Reset Password</title>
</head>
<body>
<h4>Re-set Password</h4>
<hr>
<form:form method="POST" id="resetPasswordForm" action="/SpringMVCExample/resetPassword" modelAttribute="user">
   <table>
    <tr>
        <td><form:label path="username">Enter User Name:</form:label></td>
        <td><form:input path="username" id="txtUserName"/></td>
        <td>${errmsg}</td>
    </tr>
     <tr>
        <td><input type="submit" value="Reset"/>
        <a href="/SpringMVCExample/welcome">Cancel</a></td>
    </tr>
</table>  
</form:form>
<div id="basuri" style="display:none">
	<img src="http://www.allsmileys.com/files/smiley-central-entertainment/5301.gif" style="border:0px;vertical-align:middle">
	<img src="/image/default.gif">
</div>
<script type="text/javascript">
  
  // When the browser is ready...
  $(function() {
    // Setup form validation on the #register-form element
    $("#resetPasswordForm").validate({
    
        // Specify the validation rules
        rules: {
            username: "required"
        },
        
        // Specify the validation error messages
        messages: {
            username: "Please enter username"
        },
        
        submitHandler: function(form) {
 			$("#basuri").show();    	
        	form.submit();
        }
    });
  });
  
</script>
</body>
</html>