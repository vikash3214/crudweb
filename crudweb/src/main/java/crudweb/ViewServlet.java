package crudweb;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("<a href='gg.jsp'>Add New customer</a>");
		out.println("<h1>customer list</h1>");
		
		
		
				String s1=request.getParameter("account").toString();
	
		

List<Emp> list=EmpDao.getAllEmployees(s1);
		out.print("<table border='1' width='100%'");
		System.out.println();
		out.print("<tr><th>account_no</th><th>Name</th><th>panno</th><th>Email</th><th>loan</th><th>balance</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getpanno()+"</td><td>"+e.getEmail()+"</td><td>"+e.getloan()+"</td><td>"+e.getbalance()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		
		
		
		out.close();
	}
}
