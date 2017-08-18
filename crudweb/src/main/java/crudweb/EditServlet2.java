package crudweb;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("panno");
		String email=request.getParameter("email");
	int loan=Integer.parseInt(request.getParameter("loan"));
	int balance=Integer.parseInt(request.getParameter("balance"));
		
		Emp e=new Emp();
		e.setId(id);
		e.setName(name);
		e.setpanno(password);
		e.setEmail(email);
		e.setloan(loan);
		e.setbalance(balance);
		
		int status=EmpDao.update(e);
		if(status>0){
			response.sendRedirect("rs.jsp");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
