package com.musicapp.services.IServices;

import java.util.List;

import com.musicapp.entities.Category;

public interface CategoryService {
	

    void save(Category category);

    List<Category> findAll();

    Category findById(Long id);

    Category findByName(String name);

    void delete(Long id);

}
