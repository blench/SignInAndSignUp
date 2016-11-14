<%@ page language="java" import="java.lang.*,java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>插入</title>
</head>
<body>
	<%
		String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=User";
		String username = "sa";
		String password = "qwer1234";
		
		try
		{
			//加载数据库驱动
			Class.forName(driverClass);
			out.print("已经成功加载");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement("insert into tb_user values(2,'李四','123456')");
			out.print("已经成功执行");
			int i  = ps.executeUpdate();
			ps.executeQuery();
			if(i!=-1){
				out.print("已经成功执行");
			}
			/*
			while(rs.next())
			{
				out.println("用户名:"+rs.getString(2)+"密码:"+rs.getString(3));
			}
			rs.close();*/
			ps.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			out.print("发生错误");
		}
	%>
</body>
</html>
