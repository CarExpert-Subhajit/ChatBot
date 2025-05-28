<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="code.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.2/js/bootstrap.min.js">
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<div class="container">
<div class="wrapper">
<div class="title"><span>Login Form</span></div>
<center><h3 style="color: red">${message }</h3></center>
<form action="LoginServlet" method="post" onsubmit="return check()">
<div class="row">
<i class="fas fa-user"></i>
<input type="email" name="email" id="em" placeholder="Enter Email" >
</div>

<div class="row">
<i class="fas fa-lock"></i>
<input type="password" name="pass" id="pass" placeholder="Enter Password" >
</div>

<div class="row">
<i class="fas fa-lock"></i>
<input type="password" name="cpass" id="cpass" placeholder="Confirm Password" >
</div>

<div class="row button">
<input type="submit" value="Login">
</div>
<div class="signup-link">Not a member?<a href="#">Sign Up Now</a></div>
</form>

</div>
</div>
</body>
</html>