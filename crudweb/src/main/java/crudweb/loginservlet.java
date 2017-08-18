package crudweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service (HttpServletRequest request ,HttpServletResponse response) throws IOException
	{
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("t1").toString();
		String pass=request.getParameter("t2").toString();
		HttpSession session=request.getSession();
		session.setAttribute("username", uname);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			System.out.println("connection established");
	      String query="select * from userdetail where username=? and password=?"; 
          PreparedStatement pst=con.prepareStatement(query);
          pst.setString(1, uname);
          pst.setString(2, pass);
          ResultSet rs=pst.executeQuery();

          
          
         int count=0;
          while(rs.next())
		   {
			   count =count+1;
			   
			 }
			  if (count==1)
			  {
				  
			  
		response.sendRedirect("gg.jsp");
				  }
			  else 
			  {
				  System.out.println("invalid input");
			out.print("invalid");
		
				  
				  response.sendRedirect("Index.html");
			  }
			  
			}
			catch(Exception e1)
			{
				out.println("invalid exception occured ");
			}
          
           
        
     
	}       
        
         
 
}
