package com.musicapp.repositories.daoimplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.musicapp.entities.Favourite;
import com.musicapp.repositories.daointerfaces.FavouriteDao;


@Repository
public class FavouriteDaoImp implements FavouriteDao{
	
private final SessionFactory sessionFactory;
	
	public FavouriteDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	 public void save(Favourite favorite) {
	        session().persist(favorite);
	    }

	    @Override
	    public void delete(Long userId, Long songId) {
	        Favourite f = session().createQuery(
	                "FROM Favourite WHERE user.id = :uid AND song.id = :sid", Favourite.class)
	                .setParameter("uid", userId)
	                .setParameter("sid", songId)
	                .uniqueResult();

	        if (f != null) session().remove(f);
	    }

	    @Override
	    public boolean exists(Long userId, Long songId) {
	        Long count = session().createQuery(
	                "SELECT COUNT(*) FROM Favourite WHERE user.id = :uid AND song.id = :sid",
	                Long.class)
	                .setParameter("uid", userId)
	                .setParameter("sid", songId)
	                .uniqueResult();

	        return count != null && count > 0;
	    }

	    @Override
	    public List<Favourite> findByUserId(Long userId) {
	        return session().createQuery(
	                "FROM Favourite WHERE user.id = :uid", Favourite.class)
	                .setParameter("uid", userId)
	                .list();
	    }

}
