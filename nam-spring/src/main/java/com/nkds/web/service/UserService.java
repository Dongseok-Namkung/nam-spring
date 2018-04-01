package com.nkds.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkds.web.dao.UserDAO;
import com.nkds.web.model.User;

@Service
public class UserService {
	@Autowired 
	private UserDAO userDAO;
	
	public User getUserInfo(String stfno) {
		return userDAO.getUserInfo(stfno);
	}
}
