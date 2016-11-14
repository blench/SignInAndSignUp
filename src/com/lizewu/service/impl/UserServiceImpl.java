package com.lizewu.service.impl;

import java.util.ArrayList;

import com.lizewu.dao.UserDao;
import com.lizewu.dao.UserDaoImpl;
import com.lizewu.entity.User;
import com.lizewu.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao dao = new UserDaoImpl();
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addUser(User user) {
		if(dao.checkUserRepeat(user))
		{
			return 0;
		}
		else{
			
			return dao.addUser(user);
		}
		
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteUser(int id) {
		return dao.deleteUser(id);
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(int id, User user) {
		// TODO Auto-generated method stub
		dao.updateUser(id, user);
	}

	@Override
	public ArrayList<User> findAll() {
		// TODO Auto-generated method stub
		return (ArrayList<User>) dao.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public boolean userLogin(User user) {
		// TODO Auto-generated method stub
		if(dao.userLogin(user))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
