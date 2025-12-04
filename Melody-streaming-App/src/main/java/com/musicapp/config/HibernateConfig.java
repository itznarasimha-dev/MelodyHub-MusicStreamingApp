package com.musicapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Autowired
	private  DataSource datasource;
	
	  @Bean
	  public LocalSessionFactoryBean sessionFactory() {
		  LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		  sf.setDataSource(datasource);
		  sf.setPackagesToScan("com.musicapp.entities");
		  Properties prop=new Properties();
		  
		  prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		  prop.put("hibernate.hbm2ddl.auto","update");
		  prop.put("hibernate.show_sql", "true");
		  sf.setHibernateProperties(prop);
		  return sf;
	  }
	  
	  @Bean 
	  public HibernateTransactionManager transactionManager(SessionFactory sf) {
		  return new HibernateTransactionManager(sf);
	  }

}
