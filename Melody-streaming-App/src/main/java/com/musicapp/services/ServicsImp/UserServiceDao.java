package com.musicapp.services.ServicsImp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicapp.entities.User;
import com.musicapp.repositories.daoimplementations.UserDaoImp;
import com.musicapp.services.IServices.UserService;

@Service
@Transactional
public class UserServiceDao implements UserService {
	
	private final UserDaoImp userDao;
	
	public UserServiceDao(UserDaoImp userDao) {
		this.userDao=userDao;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User Login(String email, String password) {
		// TODO Auto-generated method stub
		
		User user=userDao.findByEmail(email);
		
		if(user==null)
			return null;
		
		String hashed=Integer.toString(password.hashCode());
		
		return hashed.equals(user.getPasswordHash())?user:null;
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		
		String hashed=Integer.toString(user.getPasswordHash().hashCode());
		user.setPasswordHash(hashed);
		userDao.save(user);
		
	}

	@Override
	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		
		return userDao.findByEmail(email)!=null;
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}
	
}
