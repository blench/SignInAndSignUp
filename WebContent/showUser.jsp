<%@page import="com.lizewu.entity.User"%>
<%@ page language="java" import="java.util.*,com.lizewu.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>显示用户名和密码</title>
</head>
<body>
	<%
	String msg = (String)request.getAttribute("msg"); 
	out.println(msg+"<br/>");
	%>
	<%
		ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
		
		for(User user:list)
		{%>
		
			<table border="1px" collspan="3">
				<tr>
					<td>ID编号</td>
					<td>用户名:</td>
					<td>性别:</td>
					<td>爱好:</td>
				</tr>
				<tr>
					<td><%=user.getId() %></td>
					<td><%=user.getUsername() %></td>
					<td><%=user.getGender() %></td>
					<td><%=user.getInterest() %></td>
				</tr>
			</table>
			
		<% }%>
	
</body>
</html>