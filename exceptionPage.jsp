<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Exception</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<h4>Employee Management Exception Handling</h4>
<hr>
<h3><span class="error">${exception.exceptionMsg}</span></h3>
<div>
	<img src="http://www.allsmileys.com/files/smiley-central-communicate/5268.gif" style="border:0px;vertical-align:middle">
</div>
<br><br>
<a href="/SpringMVCExample/" class="btn btn-success btn-lg">
      <span class="glyphicon glyphicon-home"></span>
</a>
</body>
</html>