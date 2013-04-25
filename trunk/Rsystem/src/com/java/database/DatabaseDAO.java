package com.java.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseDAO 
{
	public String loginCheck(String driver,String url,String user,String pwd,String username,String password)
	{
		String result="failed";
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=new DatabaseConnections().connectionOpen(driver,url,user,pwd);
			if(con!=null)
			{
				ps=con.prepareStatement(DatabaseQueries.loginCheck);
				ps.setString(1, username);
				ps.setString(2, password);
				System.out.println(ps);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					String status=rs.getString("Status");
					if(status.equalsIgnoreCase("1"))
					{
						result="success";
					}else
						result="this is invalid user";
				}
			}else
				result="failed to connect database";
		}catch(Exception e)
		{
			result=e.toString();
		}
		return result;
	}

}
