package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnections 
{

	public Connection connectionOpen(String driver, String url, String user,String pwd) 
	{
		Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pwd);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
}
