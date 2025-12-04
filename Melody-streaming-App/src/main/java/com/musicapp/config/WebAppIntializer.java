package com.musicapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration.Dynamic;

public class WebAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	  private static final String TMP_FOLDER = "/tmp";
	    private static final int MAX_UPLOAD_SIZE = 1024 * 1024 * 100;	
	    
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{
				AppConfig.class
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {
				WebConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	 @Override
	    protected void customizeRegistration(Dynamic registration) {

		  String uploadDir = "C:/upload-temp";
		    java.io.File uploadDirectory = new java.io.File(uploadDir);
		    if (!uploadDirectory.exists()) {
		        uploadDirectory.mkdirs();
		    }

		    MultipartConfigElement multipartConfig = new MultipartConfigElement(
		            uploadDir,
		            1024 * 1024 * 100,    // 100 MB max file size
		            1024 * 1024 * 200,    // 200 MB request size
		            1024 * 1024 * 50      // 50 MB threshold
		    );

		    registration.setMultipartConfig(multipartConfig);
	    }
	

}
