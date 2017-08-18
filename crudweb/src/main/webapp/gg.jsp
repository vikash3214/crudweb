<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body oncontextmenu="return false;">
<%
if(session.getAttribute("username")==null){
response.sendRedirect("index.jsp");
}

 %>
<h1>add new customer</h1>
<form action="SaveServlet" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
<tr><td>pan-no:</td><td><input type="text" name="panno"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>balance:</td><td><input type="number" name="balance"/></td></tr>
<tr><td>loan:</td><td><input type="number" name="loan"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Save customer"/></td></tr>

</table>
</form>

<br/>
<a href="rs.jsp">view customers</a>

</body>
</html>