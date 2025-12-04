package com.musicapp.repositories.daoimplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.musicapp.entities.PlayListSong;
import com.musicapp.repositories.daointerfaces.PlayListSongDao;

@Repository
public class PlayListSongDaoImp implements PlayListSongDao{
	
	
private final SessionFactory sessionFactory;
	
	public PlayListSongDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	  public void save(PlayListSong ps) {
	        session().persist(ps);
	    }

	    @Override
	    public void delete(Long id) {
	    	PlayListSong ps = findById(id);
	        if (ps != null) session().remove(ps);
	    }

	    @Override
	    public PlayListSong findById(Long id) {
	        return session().get(PlayListSong.class, id);
	    }

	    @Override
	    public List<PlayListSong> findAllByPlayListId(Long playlistId) {
	        return session().createQuery(
	                "FROM PlayListSong WHERE playlist.id = :pid ORDER BY position ASC", 
	                PlayListSong.class)
	                .setParameter("pid", playlistId)
	                .list();
	    }

	    @Override
	    public boolean exists(Long playlistId, Long songId) {
	        Long count = session().createQuery(
	                "SELECT COUNT(*) FROM PlayListSong WHERE playlist.id = :pid AND song.id = :sid",
	                Long.class)
	                .setParameter("pid", playlistId)
	                .setParameter("sid", songId)
	                .uniqueResult();

	        return count != null && count > 0;
	    }

		
		
 
}
