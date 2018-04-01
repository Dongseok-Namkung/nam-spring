package com.nkds.nam.main.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbsRepsitory {
	@Autowired
	protected SqlSessionFactory sqlSessionFactory;
	protected SqlSession sqlSession;
	
	public AbsRepsitory() {
		sqlSession = sqlSessionFactory.openSession();
	}
}
