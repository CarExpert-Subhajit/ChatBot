<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome:</h1>
<%
if(session!=null)
{
	if(session.getAttribute("email")!=null)
	{
		String e=(String)session.getAttribute("email");
		out.print(e);
	}else
	{
		response.sendRedirect("index.jsp");
	}
}
%>
<form action="<%=request.getContextPath() %>/LogoutServlet" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>