package com.musicapp.repositories.daointerfaces;

import java.util.List;

import com.musicapp.entities.User;

public interface UserDao {
	
	 	void save(User user);

	    void update(User user);

	    void delete(Long id);

	    User findById(Long id);

	    User findByEmail(String email);

	    List<User> findAll();

}
