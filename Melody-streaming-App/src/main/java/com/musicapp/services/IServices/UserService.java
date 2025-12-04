package com.musicapp.services.IServices;

import java.util.List;

import com.musicapp.entities.User;

public interface UserService {
	
	List<User> findAll();
	
	User Login(String email,String password);
	
	void register(User user);
	
	boolean emailExist(String email);
	
	User findById(Long id);
	

}
