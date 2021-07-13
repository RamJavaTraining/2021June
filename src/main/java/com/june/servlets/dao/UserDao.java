package com.june.servlets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.june.servlets.modal.User;

public class UserDao {
	
	
	public boolean isUserExists(int userId) {
		
		return true;
	}
	
    public User getUser(int userId) {
    	
    	
    	EntityManagerFactory emf= Persistence.createEntityManagerFactory("test");
    	EntityManager em= emf.createEntityManager();
    	
    	EntityTransaction transaction= em.getTransaction();
    	transaction.begin();
    	
    	User user = new User();
    	user.setUserId(12345);
    	user.setUserName("Krishna");
    	
    	em.persist(user);
    	
    	Query query= em.createQuery("Select t from User t");
    	List<User> users =  (List<User>)query.getResultList();
    	
    	transaction.commit();
    	 return users.get(1);
    	
    	
    	/*
    	User user= new User();
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection connection =connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			Statement statement=  connection.createStatement();
		ResultSet res=	statement.executeQuery("select * from user");
		while(res.next()) {
			
			
			user.setUserId(res.getInt("user_id"));
			user.setUserName(res.getString("user_name"));
			
		}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return user;
		
		*/
	}

}
