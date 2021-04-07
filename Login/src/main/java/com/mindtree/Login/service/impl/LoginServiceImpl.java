package com.mindtree.Login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Login.entity.User;
import com.mindtree.Login.repository.UserRepository;
import com.mindtree.Login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		
		User user=repository.findUser(username, password);
		
		if(user == null) {
			return false;
		}
		else {
			return true;
		}
		
	}

}
