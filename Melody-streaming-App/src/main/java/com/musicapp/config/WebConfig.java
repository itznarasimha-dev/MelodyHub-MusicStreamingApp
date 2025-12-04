package com.musicapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import jakarta.servlet.ServletContext;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.musicapp.controllers")
public class WebConfig implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Autowired
	private ServletContext context;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

	    registry.addResourceHandler("/resources/**")
	            .addResourceLocations("/resources/");

//	    String uploadPath = "file:" + context.getRealPath("/uploads/");
//	    registry.addResourceHandler("/uploads/**")
//	            .addResourceLocations(uploadPath);
	    
	    registry.addResourceHandler("/uploads/**")
        .addResourceLocations("file:" + System.getProperty("user.dir") + "/uploads/");
	}

  @Bean
  public StandardServletMultipartResolver multipartResolver() {
      return new StandardServletMultipartResolver();
  }

}
