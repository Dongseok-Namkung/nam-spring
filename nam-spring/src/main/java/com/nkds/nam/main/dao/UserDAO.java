package com.nkds.nam.main.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nkds.nam.main.vo.UserVO;

@Repository

public class UserDAO{
	@Resource(name="sqlSessionFactoryPrimary")
	private SqlSessionFactory sqlSessionFactoryPrimary;
	private SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public UserVO getUserInfo(String stfno) {
		
		UserVO userVO = sqlSessionTemplate.selectOne("selectUser", stfno);
		logger.info("@@userVO:"+userVO.getNm());
		return userVO;
	}
}
