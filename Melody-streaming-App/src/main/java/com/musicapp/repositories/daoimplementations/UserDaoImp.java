package com.musicapp.repositories.daoimplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.musicapp.entities.User;
import com.musicapp.repositories.daointerfaces.UserDao;


@Repository
public class UserDaoImp implements UserDao{

	
	private final SessionFactory sessionFactory;
	
	
	UserDaoImp(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		session().persist(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		session().merge(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		User user=findById(id);
		session().remove(user);
		
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		
		return session().get(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		
		User user=session().createQuery("FROM User WHERE email=:email",User.class)
				.setParameter("email", email)
				.uniqueResult();
		
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> list=session().createQuery("FROM User",User.class)
				.list();
		return list;
	}

}
