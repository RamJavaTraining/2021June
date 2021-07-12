package com.june.servlets.dao;

import com.june.servlets.modal.User;

public class UserDao {
	
	
	public boolean isUserExists(int userId) {
		
		return true;
	}
	
    public User getUser(int userId) {
    	
    	User user = new User();
    	user.setUserId(userId);
    	
    	return user;
		
		
	}

}
