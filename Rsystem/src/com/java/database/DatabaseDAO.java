package com.java.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

import com.java.struts.profile.UserDataPojo;

public class DatabaseDAO 
{
	TimeZone tz=null;	
	public DatabaseDAO()
	{
		tz=TimeZone.getDefault();
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:30"));
	}
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

	public String registration(String driver, String url, String user,String pwd, HashMap<String, String> datamap) 
	{
		String result="failed";
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=new DatabaseConnections().connectionOpen(driver,url,user,pwd);
			if(con!=null)
			{
				String currentdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance(tz).getTime());
				
				ps=con.prepareStatement(DatabaseQueries.registration);
				ps.setString(1, datamap.get("uname"));
				ps.setString(2, datamap.get("pwd"));
				ps.setString(3, "1");
				ps.setString(4, datamap.get("fname"));
				ps.setString(5, datamap.get("lname"));
				ps.setString(6, datamap.get("email"));
				ps.setString(7, datamap.get("address"));
				ps.setString(8, datamap.get("city"));
				ps.setString(9, datamap.get("state"));
				ps.setString(10, datamap.get("pin"));
				ps.setString(11, currentdate);				
				int i=ps.executeUpdate();
				if(i>0)
				{
					result="success";
				}
			}else
				result="failed to connect database";
		}catch(Exception e)
		{
			result=e.toString();
		}
		return result;
	}
	public UserDataPojo getUserInformation(String driver, String url,String user, String pwd, String username, String password) 
	{
		UserDataPojo resultpojo=null;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=new DatabaseConnections().connectionOpen(driver,url,user,pwd);
			if(con!=null)
			{
				
				ps=con.prepareStatement(DatabaseQueries.getProfileData);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					resultpojo=new UserDataPojo();
					resultpojo.setUserName(rs.getString("UserName"));
					resultpojo.setPassword(rs.getString("Password"));
					resultpojo.setStatus(rs.getString("Status"));
					resultpojo.setFirstName(rs.getString("FirstName"));
					resultpojo.setLastName(rs.getString("LastName"));
					resultpojo.setEmail(rs.getString("Email"));
					resultpojo.setAddress(rs.getString("Address"));
					resultpojo.setCity(rs.getString("City"));
					resultpojo.setState(rs.getString("State"));
					resultpojo.setPincode(rs.getString("Pincode"));
					resultpojo.setRegisterDate(rs.getString("RegisterDate"));
					resultpojo.setUid(rs.getString("UserId"));
				}
			}
		}catch(Exception e)
		{
			
		}
		return resultpojo;
	}
	public String updateUserInformation(String driver, String url,String user, String pwd, String username, String password,String fname, String lname, String email, String address,String city, String state, String pincode,String uid) 
	{
		String result="failed";
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=new DatabaseConnections().connectionOpen(driver,url,user,pwd);
			if(con!=null)
			{
				
				ps=con.prepareStatement(DatabaseQueries.updateProfile);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, fname);
				ps.setString(4, lname);
				ps.setString(5, email);
				ps.setString(6, address);
				ps.setString(7, city);
				ps.setString(8, state);
				ps.setString(9, pincode);
				ps.setString(10, uid);
				System.out.println(ps);
				int k=ps.executeUpdate();
				if(k>0)
					result="success";
				
			}
		}catch(Exception e)
		{
			
		}
		return result;
	}

}
