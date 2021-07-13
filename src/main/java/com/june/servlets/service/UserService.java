package com.june.servlets.service;

import com.june.servlets.dao.UserDao;
import com.june.servlets.modal.User;

public class UserService {
	
	
	private UserDao userDao;
	
	public UserService() {
	userDao= new UserDao();
	}
	
	public boolean isUserExists(int userId) {
		
		return userDao.isUserExists(userId);
		
	}
	
	public User getUser(int userId) {
		
		User user = userDao.getUser(userId);
		return user;
	}

}
