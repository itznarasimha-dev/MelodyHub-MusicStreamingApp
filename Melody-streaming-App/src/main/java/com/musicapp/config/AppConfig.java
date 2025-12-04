package com.musicapp.config;





import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
	DataSourceConfig.class,
	HibernateConfig.class
})
@ComponentScan(basePackages="com.musicapp")

public class AppConfig {
	
	  
}
