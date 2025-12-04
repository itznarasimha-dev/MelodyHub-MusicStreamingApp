package com.musicapp.repositories.daoimplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.musicapp.entities.Category;
import com.musicapp.repositories.daointerfaces.CategoryDao;

@Repository
public class CategoryDaoImp implements CategoryDao{
	
private final SessionFactory sessionFactory;
	
	public CategoryDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		session().persist(category);
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		session().merge(category);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Category category=findById(id);
		session().remove(category);
		
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return session().get(Category.class, id);
	}

	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		Category category=session().createQuery("FROM Category WHERE name=:n",Category.class)
				.setParameter("n", name)
				.uniqueResult();
		return category;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return session().createQuery("FROM Category",Category.class).list();
	}

}
