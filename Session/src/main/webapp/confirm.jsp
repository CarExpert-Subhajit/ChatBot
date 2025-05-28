<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%
HashMap<String,String> userDetails=(HashMap)session.getAttribute("user");
String firstName="";
String lastName="";
String username="";
if(userDetails!=null)
{
	firstName=userDetails.get("firstname");
	lastName=userDetails.get("lastname");
	username=userDetails.get("username");
}else
{
	firstName=null;
	lastName=null;
	username=null;
}
%>
<table align="center" bgcolor="#728dcf">
<tr>
<td>First Name:</td>
<td><%= firstName %></td>
</tr>

<tr>
<td>Last Name:</td>
<td><%= lastName %></td>
</tr>

<tr>
<td>User Name:</td>
<td><%= username %></td>
</tr>
</table>
</body>
</html>