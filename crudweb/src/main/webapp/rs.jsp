<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="crudweb.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drop Downlist</title>
</head>
<body oncontextmenu="return false;">

<%
if(session.getAttribute("username")==null){
response.sendRedirect("index.jsp");
}

 %>
 <a href="gg.jsp">add customer</a>

<form action="rr.jsp">

<%

try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	
	Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
String sql = "SELECT * FROM user905";
 PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery(); 
%>
<p>Select Name :
<select name ="account">
<%
while(rs.next())
{
String fname = rs.getString("id"); 
%>
<option value="<%=fname %>"><%=fname %></option>
<%
}
%>
</select>
</p>
<%
}
catch(SQLException sqe)
{ 
out.println("invalid action");
}
catch (Exception f)
{
	out.println("invalid action");
}
%>
<input type="submit" value="list">
<%
try{
String s1=request.getParameter("account");
}
catch(Exception g)
{
	out.println("invalid action");
}
%>

</form>
</body>
</html>