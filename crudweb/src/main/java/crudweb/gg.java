package crudweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class gg {

	public static List<Emp> customer(String s2){
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
}


