package crudweb;

import java.util.*;
import java.io.PrintWriter;
import java.sql.*;

public class EmpDao {

	
	
	public static int save(Emp e){
		int status=0;
		try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			PreparedStatement ps=con.prepareStatement("insert into user905 values (account_no.NEXTVAL,?,?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getpanno());
			ps.setString(3,e.getEmail());
			ps.setInt(4, e.getbalance());
			ps.setInt(5,e.getloan());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex)
		{
			System.out.println("you have intered some irrelevent data");
			
		
		}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");;
			PreparedStatement ps=con.prepareStatement("update user905 set name=?,panno=?,email=?,loan=?,balance=? where id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getpanno());
			ps.setString(3,e.getEmail());
			ps.setInt(4,e.getloan());
			ps.setInt(5, e.getbalance());
			ps.setInt(6,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Emp getEmployeeById(String id){
		Emp e=new Emp();
		int ib=Integer.parseInt(id);
		try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");
			ps.setInt(1,ib);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setpanno(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setloan(rs.getInt(6));
				e.setbalance(rs.getInt(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(String s2){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			System.out.println(s2);
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			PreparedStatement ps=con.prepareStatement("select * from user905 where id =?");
			ps.setInt(1,Integer.parseInt(s2));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setpanno(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setloan(rs.getInt(6));
				e.setbalance(rs.getInt(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}

		return list;
		
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
						  
					
						Connection con=DriverManager.getConnection(  
								"jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
						PreparedStatement ps=con.prepareStatement("select * from user905");
						
						ResultSet rs=ps.executeQuery();
						while(rs.next()){
							Emp e=new Emp();
							e.setId(rs.getInt(1));
							e.setName(rs.getString(2));
							e.setpanno(rs.getString(3));
							e.setEmail(rs.getString(4));
							e.setloan(rs.getInt(6));
							e.setbalance(rs.getInt(5));
							list.add(e);
						}
						con.close();
					}catch(Exception e){e.printStackTrace();}

					return list;
					
				}
}
