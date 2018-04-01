package com.nkds.web.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbsRepsitory {
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	
}
