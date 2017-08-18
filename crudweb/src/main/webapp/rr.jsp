<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="crudweb.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body oncontextmenu="return false;">
<%

	String s1=request.getParameter("account");
	List<Emp> list=EmpDao.getAllEmployees(s1);


out.print("<table border='1' width='100%'");

out.print("<tr><th>account_no</th><th>Name</th><th>panno</th><th>Email</th><th>balance</th><th>loan</th><th>Edit</th><th>Delete</th></tr>");
for(Emp e:list){
	out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getpanno()+"</td><td>"+e.getEmail()+"</td><td>"+e.getbalance()+"</td><td>"+e.getloan()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
}
out.print("</table>");
System.out.println(s1);

Emp e=EmpDao.getEmployeeById(s1);

out.print("<form action='EditServlet2' method='post'>");
out.print("<table>");
out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
out.print("<tr><td>Panno:</td><td><input type='text' name='panno' value='"+e.getpanno()+"'/></td></tr>");
out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
out.print("<tr><td>balance:</td><td><input type='number' name='balance' value='"+e.getbalance()+"'/></td></tr>");
out.print("<tr><td>loan:</td><td><input type='number' name='loan' value='"+e.getloan()+"'/></td></tr>");

out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
out.print("</table>");
out.print("</form>");

%>

</body>
</html>