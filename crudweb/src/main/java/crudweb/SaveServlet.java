package crudweb;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
		String name=request.getParameter("name");
		String panno=request.getParameter("panno");
		String email=request.getParameter("email");
		int balance=Integer.parseInt(request.getParameter("balance"));
	int loan=Integer.parseInt(request.getParameter("loan"));
		
		Emp e=new Emp();
		e.setName(name);
		e.setpanno(panno);
		e.setEmail(email);
		e.setbalance(balance);
		e.setloan(loan);
	
		int status=EmpDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("gg.jsp").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
		
	}
		catch(Exception ex)
	{
			out.print("enetered some irrelevent data");
	}
	}

}
