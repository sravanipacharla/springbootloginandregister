package com.crud.example.service;

import com.crud.example.entity.User;

public interface UserService   {
	
	 User registerUser(User user);
	 
	 boolean loginUser(String username, String password,String email);

}
	
	
	

