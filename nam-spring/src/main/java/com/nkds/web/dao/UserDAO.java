package com.nkds.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nkds.web.model.User;

@Repository
public class UserDAO extends AbsRepsitory{
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	public User getUserInfo(String stfno) {
		return sqlSessionTemplate.selectOne("selectUser", stfno);
	}
}
