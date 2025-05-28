<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<form class="frm" name="RegForm" action="EmployeeServlet" onsubmit="return validateForm()" method="post">
<div>
<input type="hidden" name="id" id="id" value="">
</div>

<div>
<label>First Name</label>
<input type="text" name="firstname" id="firstname">
</div>

<div>
<label>Last Name</label>
<input type="text" name="lastname" id="lastname">
</div>

<div>
<label>User Name</label>
<input type="text" name="username" id="users">
</div>

<div>
<label>Password</label>
<input type="password" name="password" id="pass">
</div>

<div>
<label>Address</label>
<input type="text" name="address" id="address">
</div>

<div>
<label>Contact No</label>
<input type="text" name="contact" id="contact">
</div>
<div class="buttons">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</div>
</form>
</body>
</html>