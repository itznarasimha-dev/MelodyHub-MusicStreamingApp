package com.musicapp.repositories.daoimplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.musicapp.entities.PlayList;
import com.musicapp.repositories.daointerfaces.PlayListDao;


@Repository
public class PlayListDaoImp implements PlayListDao{

	
private final SessionFactory sessionFactory;
	
	public PlayListDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(PlayList playList) {
		// TODO Auto-generated method stub
		session().persist(playList);
		
	}

	@Override
	public void update(PlayList playList) {
		// TODO Auto-generated method stub
		session().merge(playList);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		session().remove(findById(id));
		
	}

	 @Override
	    public PlayList findById(Long id) {
	        return session().get(PlayList.class, id);
	    }

	    @Override
	    public List<PlayList> findAllByUserId(Long userId) {
	        return session().createQuery(
	                "FROM PlayList WHERE user.id = :uid", PlayList.class)
	                .setParameter("uid", userId)
	                .list();
	    }

	    @Override
	    public List<PlayList> findAll() {
	        return session().createQuery("FROM PlayList", PlayList.class).list();
	    }

}
