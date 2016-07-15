<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Contact</title>
</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.6";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
<h4>Contact</h4>
<hr>
<div class="container">
  <div class="panel-group">
    <div class="panel panel-success">
      <div class="panel-heading">Home Address</div>
      <div class="panel-body">
      Jayanthi Nilayam, No 16, NGR Layout,
      Roopena Agrahara, Bangalore-560068
      </div>
    </div>

    <div class="panel panel-info">
      <div class="panel-heading">Websites</div>
      <div class="panel-body">https://in.linkedin.com/in/kumaranil4283</div>
    </div>

    <div class="panel panel-warning">
      <div class="panel-heading"><span class="glyphicon glyphicon-envelope">  Email</span></div>
      <div class="panel-body">sendkumaranil@gmail.com</div>
    </div>

    <div class="panel panel-danger">
      <div class="panel-heading">Phone</div>
      <div class="panel-body">(+91) 8860543130</div>
    </div>
    
    <div class="panel panel-warning">
      <div class="panel-heading">Social Media</div>
      <div class="panel-body">
      	<a href="https://twitter.com/anitowrite" class="twitter-follow-button" data-show-count="false">Follow @anitowrite</a>
      </div>
    </div>
    
  </div>
</div>
<div align="right" class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-layout="standard" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>
<hr>
<a href="/SpringMVCExample/" class="btn btn-success btn-lg">
      <span class="glyphicon glyphicon-home"></span>
    </a>

</body>
</html>