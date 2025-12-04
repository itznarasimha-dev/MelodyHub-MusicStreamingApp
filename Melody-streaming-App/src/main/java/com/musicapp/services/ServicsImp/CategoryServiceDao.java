package com.musicapp.services.ServicsImp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicapp.entities.Category;
import com.musicapp.repositories.daoimplementations.CategoryDaoImp;
import com.musicapp.services.IServices.CategoryService;

@Service
@Transactional
public class CategoryServiceDao implements CategoryService {
    
	private final CategoryDaoImp categoryDao;
	
	public CategoryServiceDao(CategoryDaoImp categoryDao) {
		this.categoryDao=categoryDao;
	}
	
	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryDao.save(category);
		
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id);
	}

	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return categoryDao.findByName(name);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoryDao.delete(id);
		
	}

}
