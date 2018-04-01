package com.nkds.nam.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkds.nam.main.dao.UserDAO;
import com.nkds.nam.main.vo.UserVO;

@Service
public class UserService {
	@Autowired 
	private UserDAO userDAO;
	
	public UserVO getUserInfo(String stfno) {
		return userDAO.getUserInfo(stfno);
	}
}
