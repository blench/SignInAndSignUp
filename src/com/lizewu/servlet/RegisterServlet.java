package com.lizewu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizewu.dao.UserDao;
import com.lizewu.dao.UserDaoImpl;
import com.lizewu.entity.User;
import com.lizewu.service.UserService;
import com.lizewu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService service = new UserServiceImpl();
    User user = new User();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//1.通过name获取参数值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String interest = request.getParameter("interest");
		String msg = null;
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setInterest(interest);
		
		//2.将数据插入到数据库中
		int count = service.addUser(user);
		if(count>0)
		{
			msg = "注册成功";
			request.setAttribute("msg", msg);
			//request.setAttribute("user", user);
//			ArrayList<User> users = (ArrayList<User>) service.findAll();
//			request.setAttribute("users", users);
			
			//发送数据
			request.getRequestDispatcher("showUser.jsp").forward(request, response);
		}else
		{
			msg = "该用户已经注册过,<a href='register.jsp'>请重新注册</a>";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("repeatUser.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
