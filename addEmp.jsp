<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Add New Employee</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<h4>Add Employee Information</h4>
<hr>
<form:form method="POST" action="/SpringMVCExample/manageEmp/addEmployee" modelAttribute="employee">
   <table>
    <tr>
        <td><form:label path="empname">Name:</form:label></td>
        <td><form:input path="empname"/></td>
        <td><form:errors path="empname" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="dob">Date Of Birth:</form:label></td>
        <td><form:input path="dob" /></td>
        <td><form:errors path="dob" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="doj">Date of Joining:</form:label></td>
        <td><form:input path="doj" /></td>
        <td><form:errors path="doj" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="emailid">E-mail:</form:label></td>
        <td><form:input path="emailid" /></td>
        <td><form:errors path="emailid" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="mobileno">Mobile No:</form:label></td>
        <td><form:input path="mobileno" /></td>
        <td><form:errors path="mobileno" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="idtype">ID type:</form:label></td>
        <td><form:input path="idtype" /></td>
        <td><form:errors path="idtype" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="idno">ID No:</form:label></td>
        <td><form:input path="idno" /></td>
        <td><form:errors path="idno" cssClass="error" /></td>
    </tr>
    <tr>
    	<td>Select Department:</td>
    	<td>
    		<form:select path="deptid">
 				<form:option value="-1" label="-----Select Department-----"></form:option>
 				<form:options items="${deptList}" itemValue="deptid" itemLabel="deptname"/>
 			</form:select>
    	</td>
    	<td><form:errors path="deptid" cssClass="error" /></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Submit"/>
        </td>
        <td>
        	<a href="/SpringMVCExample/welcome">Cancel</a>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>