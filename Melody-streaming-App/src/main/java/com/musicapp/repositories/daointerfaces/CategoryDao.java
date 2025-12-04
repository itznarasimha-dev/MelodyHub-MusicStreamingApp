package com.musicapp.repositories.daointerfaces;

import java.util.List;

import com.musicapp.entities.Category;
import com.musicapp.entities.User;

public interface CategoryDao {
	
	void save(Category category);

    void update(Category category);

    void delete(Long id);

    Category findById(Long id);
    
    Category findByName(String name);

    List<Category> findAll();

}
