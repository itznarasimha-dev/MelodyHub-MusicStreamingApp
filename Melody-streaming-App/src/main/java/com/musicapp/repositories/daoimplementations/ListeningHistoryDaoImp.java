package com.musicapp.repositories.daoimplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.musicapp.entities.ListeningHistory;
import com.musicapp.repositories.daointerfaces.ListenHistoryDao;


@Repository
public class ListeningHistoryDaoImp implements ListenHistoryDao{
	

private final SessionFactory sessionFactory;
	
	public ListeningHistoryDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	 @Override
	    public void save(ListeningHistory history) {
	        session().persist(history);
	    }

	    @Override
	    public List<ListeningHistory> findByUserId(Long userId) {
	        return session().createQuery(
	                "FROM ListeningHistory WHERE user.id = :uid ORDER BY playedAt DESC", 
	                ListeningHistory.class)
	                .setParameter("uid", userId)
	                .list();
	    }

	    @Override
	    public List<ListeningHistory> findRecentByUserId(Long userId) {
	        return session().createQuery(
	                "FROM ListeningHistory WHERE user.id = :uid ORDER BY playedAt DESC", 
	                ListeningHistory.class)
	                .setParameter("uid", userId)
	                .setMaxResults(20)
	                .list();
	    }

}
