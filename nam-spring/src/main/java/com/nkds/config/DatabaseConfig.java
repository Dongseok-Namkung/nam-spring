package com.nkds.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author NKDS
 * @version 1.0
 * @since 1.0
 *
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
    private ApplicationContext applicationContext;
	
	/**
	 * @param 
	 * @return DataSource
	 * @exception 
	 * @see
	 * @since
	 * 
	 */

	@Bean
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("jdbc/namDS");
        
        return dataSource;
    } 
	
	@Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    @Primary
    public SqlSessionFactoryBean sqlSessionFactoryPrimary() throws Exception {
    	
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource((DataSource)applicationContext.getBean("dataSource"));
//        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
        
        return sessionFactoryBean;
    }
    
    @Bean 
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) { 
    	return new SqlSessionTemplate(sqlSessionFactory); 
    } 

}
