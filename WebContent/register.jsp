<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/RegisterServlet" method="get">
		用户名:<input type="text" name="username" /><br/>
		密码:<input type="text" name="password"/><br/>
		性别:<input type="text" name="gender"/><br/>
		爱好:<input type="text" name="interest"/><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>