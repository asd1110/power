package com.wipro.power.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil 
{
	public static Connection con;
	public static Connection getDBConnection()
	{
		try	
		{
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:odbc:thin:@localhost:1521:ORCL";
			String userName="B44641345113";
			String pwd="B44641345113";
			Connection con=DriverManager.getConnection(url, userName, pwd);
			return con;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	}
}
