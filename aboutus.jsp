<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>About Us</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAmmqDYmV_bhrlgez9-klLHPDxOipXTmuA"></script>
<script>
function initialize() {
  var mapProp = {
    center:new google.maps.LatLng(12.910569,77.623520),
    zoom:9,
    mapTypeId:google.maps.MapTypeId.HYBRID
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>

<div class="jumbotron">
  <h1>Employee Management System</h1>
  <p>We specialize in Employee management system</p>
</div>

<hr>
<div>
<a href="/SpringMVCExample/" class="btn btn-success btn-lg">
  <span class="glyphicon glyphicon-home"></span>
</a>
<p align="right"><i>Created By: Anil Kumar</i></p>
</div>
<div id="googleMap" style="width:1900px;height:580px;"></div>
</body>
</html>