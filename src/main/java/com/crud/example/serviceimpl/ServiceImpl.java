package com.crud.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.entity.User;
import com.crud.example.repository.UserRepository;
import com.crud.example.service.UserService;

@Service
public class ServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public User registerUser(User user) {
		return userrepository.save(user);
	}

	@Override
	public boolean loginUser(String username, String password,String email) {
		 User user = userrepository.findByUsername(username);
	        if (user != null && user.getPassword().equals(password)&& user.getEmail().equals(email)&&user.getUserName().equals(username)) {
	            return true;
	        }
		
		return false;
	}
	
	
	
	

}
