package com.lizewu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lizewu.entity.User;
import com.lizewu.service.UserService;
import com.lizewu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DoLoginServlet
 */
//@WebServlet("/DoLoginServlet")这句话必须删掉,否则tomcat会报错
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService service = new UserServiceImpl();
    User user = null;
    String msg = "";
    String username = "";
    String pwd = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		user = new User();
		 username = request.getParameter("username");
		 pwd = request.getParameter("password");
		user.setUsername(username);
		user.setPassword(pwd);
		if(service.userLogin(user))
		{
			response.sendRedirect("success.jsp");
			
		}else
		{
			response.sendRedirect("fail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
