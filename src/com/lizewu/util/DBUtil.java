package com.lizewu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DBUtil {
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=User";
	public static String username = "sa";
	public static String password = "qwer1234";
	
	/*
	static
	{
		try {
			//注册数据库驱动
			Class.forName(driverName);
			//连接数据库
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	*/
//	public static ResultSet getResultSet(String sql)
//	{
//		//执行查询语句
//		if(sql!=null)
//		{
//			try {
//				ps = conn.prepareStatement(sql);
//				rs = ps.executeQuery(sql);
//				return rs;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return rs;
//		
//	}
//	
	//执行插入语句,返回受影响行数
	public static int insertIntoDB(String sql)
	{
		int count =0;
		if(sql!=null)
		{
			try {
				ps = conn.prepareStatement(sql);
				count = ps.executeUpdate(sql);
				return count;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
		
	}
	
	public static Connection getConnection()
	{
		
			try {
				//注册数据库驱动
				Class.forName(driverName);
				//连接数据库
				conn = DriverManager.getConnection(url,username,password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn)
	{
		try {
			if(rs!=null)
			{
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(ps!=null)
			{
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			{
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
