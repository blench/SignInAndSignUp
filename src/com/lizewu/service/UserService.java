package com.lizewu.service;

import java.util.ArrayList;

import com.lizewu.entity.User;

public interface UserService {
	
	public int addUser(User user);
	
	public boolean deleteUser(int id);
	
	public void updateUser(int id,User user);
	
	public ArrayList<User> findAll();
	
	public User findById(int id);
	
	public boolean userLogin(User user);
	
	
}
