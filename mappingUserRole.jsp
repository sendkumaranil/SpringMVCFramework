<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript">
	var contexPath = "<%=request.getContextPath() %>";
	
	function doAjaxPost(mappingid) {  
		  // get the form values  
		  $.ajax({  
		    type: "POST",  
		    url: contexPath + "/usermanage/removeMappedUsers",  
		    data: "mappingid=" + mappingid ,  
		    success: function(response){
		    	window.location.replace(response);
		    },  
		    error: function(e){  
		      alert('Error: ' + e);  
		    }  
		  });  
		}
	
	
</script>
<title>Mapping User And Role</title>
<style>
	.error{
		color: red;
	}

	.success{
		color: green;
	}
</style>
</head>
<body>
<h4>Assign Role to User</h4>
<hr>
<div>
<form:form method="post" action="/SpringMVCExample/usermanage/processMapping" modelAttribute="userRoleMap">
 <table>
 <tr>
 <td>Select Roles</td>
 <td>
 <form:select path="roleid">
 	<form:option value="-1" label="-Select Role-"></form:option>
 	<form:options items="${rolelist}" itemValue="roleid" itemLabel="rolename"/>
 </form:select>
 </td>
 </tr>
 <tr>
 <td>Select Users</td>
 <td>
 <form:select path="userid">
 	<form:option value="-1" label="-Select User-"></form:option>
 	<form:options items="${userlist}" itemValue="userid" itemLabel="username"/>
 </form:select>
 </td>
 </tr>
 <tr>
 <td></td><td><input type="submit" value="Submit"></td>
 </tr>
 </table>
 </form:form>
</div>
<hr>
<h4>Roles assigned to users details:</h4>
<form:form action="/usermanage/removeMappedUsers" method="POST" modelAttribute="userRoleMap">
<table border="1" id="tblMapping">
	<tr>
		<th>UserName</th>
		<th>Assigned Role</th>
		<th>Remove Mapping</th>
	</tr>
	<c:forEach items="${mappedUsers}" var="mappedusers" >
		<tr>
			<td>
				<c:out value="${mappedusers.username}"></c:out>
			</td>
			<td>
				<c:out value="${mappedusers.rolename}"></c:out>
			</td>
			<td>
				<%-- <input type="button" name="btnRemove" value="Remove Mapping" onclick="doAjaxPost(${mappedusers.mappingid})"> --%>
				<span class="glyphicon glyphicon-trash" onclick="doAjaxPost(${mappedusers.mappingid})"></span>
				<form:hidden path="mappingid"/>				
			</td>
		</tr>		
	</c:forEach>
</table>
</form:form>
<hr>
<a href="/SpringMVCExample/usermanage/register">Back</a>
</body>
</html>