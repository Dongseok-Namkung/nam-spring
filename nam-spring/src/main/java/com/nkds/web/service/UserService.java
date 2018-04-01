package com.nkds.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkds.web.dao.UserDAO;
import com.nkds.web.model.User;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired 
	private UserDAO userDAO;
	
	public User getUserInfo(String stfno) {
		User user = userDAO.getUserInfo(stfno);
		return user;
	}
}
