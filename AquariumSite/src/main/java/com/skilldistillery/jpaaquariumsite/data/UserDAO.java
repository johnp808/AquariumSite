package com.skilldistillery.jpaaquariumsite.data;

import java.util.List;

import com.skilldistillery.jpaaquariumsite.entities.User;

public interface UserDAO {

	List<User> findAll();

	User findById(int userId);
	
	User createUser(User user);
		
	User updateUser(int userId, User user);
	
	boolean deleteUser(int userId);
	
}
