package com.jove.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jove.demo.controller.HomeController;
import com.jove.demo.models.User;
import com.jove.demo.persistence.UserMapper;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserMapper userMapper;
	
	public User validatelogin(User user) {
		User returnValue = userMapper.getUser(user.getUserName());
		if(returnValue != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			logger.debug("password:"+encoder.encode(user.getPassword()));
			if (encoder.matches(user.getPassword(), returnValue.getPassword())) {
				returnValue.setPassword("");
				//TODO generate token
				returnValue.setToken("Logined");
				return returnValue;
			} 
		} 
		return user;
	}
}
