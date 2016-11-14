<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录注册页面</title>
<style type="text/css">
	.nav{
		
	}
	
</style>
<script type="text/javascript">
	function displaySubMenu(li)
	{
		var tag = li.getElementsByTagName("ul")[0];
		tag.dispaly.style = "block";
	}
	
	function hideSubMenu(li)
	{
		var tag = li.getElementsByTagName("ul")[0];
		tag.display.style = "none";
	}
	function checkUser()
	{
		if(document.loginForm.username.value=="")
			{
				alert("请输入用户名");
				return false;
			}
		if(document.loginForm.password.value="")
			{
				alert("请输入密码");
				return false;
			}
	}
</script>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="index.jsp">主页</a></li>
			<li onmouseover="displaySubMenu()"><a href="#">第一项</a></li>
			<li><a href="#">第三项</a></li>
			<li><a href="#">第四项</a></li>
			<li><a href="#">第五项</a></li>
			<li><a href="#">第六项</a></li>
		</ul>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/DoLoginServlet" method="post">
			用户名:<input type="text" name="username"/><br/>
			密码:<input type="password" name="password"/><br/>
			<input type="submit" value="登录"/>
			<input type="reset" value="重置"/><br/>
		</form>
		<a href="register.jsp">注册</a>
	</div>
</body>
</html>