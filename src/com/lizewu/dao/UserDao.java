package com.lizewu.dao;

import java.util.List;

import com.lizewu.entity.User;

public interface UserDao {
	
	public int addUser(User user);
	
	public boolean deleteUser(int id);
	
	public void updateUser(int id,User user);
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public boolean checkUserRepeat(User user);
	
	public boolean userLogin(User user);
}
