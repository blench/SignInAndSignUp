package com.lizewu.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lizewu.dao.UserDao;
import com.lizewu.dao.UserDaoImpl;
import com.lizewu.entity.User;
import com.lizewu.service.UserService;
import com.lizewu.service.impl.UserServiceImpl;

public class TestUserDaoImpl {
	
	UserDao dao = new UserDaoImpl() ;
	UserService service = new UserServiceImpl();	
		
	User user = new User();
	public TestUserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void init()
	{
		new UserDaoImpl();
		new User();
	}
	
	@Test
	public void testFindAll()
	{
		ArrayList<User> list = new ArrayList<User>();
		list = (ArrayList<User>)dao.findAll();
		for(User user:list)
		{
			System.out.println("用户名:"+user.getUsername());
			System.out.println("密码:"+user.getPassword());
		}
		
	}
	@Test
	public void testAddUser()
	{
		try {
			user.setUsername("张三");
			user.setPassword("123123");
			dao.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void deleteUser() 
	{
		
		try {
			boolean flag = dao.deleteUser(2);
			if(flag)
			{
				System.out.println("删除成功!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void testFindById()
	{
		User user = dao.findById(3);
		System.out.println("用户名:"+user.getUsername());
		System.out.println("密码:"+user.getPassword());
		System.out.println(user);
	}
	
	@Test 
	public void testUpdateUser()
	{
		user.setUsername("李四");
		user.setPassword("1234567");
		dao.updateUser(3, user);
		testFindAll();
	}
	
	@Test
	public void testUserLogin()
	{
		user.setUsername("张三");
		user.setPassword("1234");
		System.out.println(service.userLogin(user));
	}
}
