package com.musicapp.repositories.daoimplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.musicapp.entities.Song;
import com.musicapp.repositories.daointerfaces.SongDao;

@Repository
public class SongDaoImp implements SongDao{
	
	private final SessionFactory sessionFactory;
	
	public SongDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Song song) {
		// TODO Auto-generated method stub
		session().persist(song);
		
	}

	@Override
	public void update(Song song) {
		// TODO Auto-generated method stub
		session().merge(song);
		
	}

	@Override
	public Song findById(Long id) {
		// TODO Auto-generated method stub
		return session().get(Song.class, id);
	}

	@Override
	public List<Song> findAll() {
		// TODO Auto-generated method stub
		
		return session().createQuery("FROM Song",Song.class).list();
	}

	@Override
	public List<Song> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return session().createQuery("FROM Song WHERE LOWER(title) LIKE(:t)",Song.class)
				.setParameter("t","%"+ title+"%")
				.list();
	}

	@Override
	public List<Song> searchByArtist(String artist) {
		// TODO Auto-generated method stub
		return session().createQuery("FROM Song WHERE LOWER(artist) LIKE(:a)",Song.class)
				.setParameter("a","%"+ artist+"%")
				.list();
	}

	@Override
	public List<Song> findByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		
		return session().createQuery("FROM Song WHERE category_id=:cid",Song.class)
				.setParameter("cid","%"+ categoryId+"%")
				.list();
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Song song=findById(id);
		session().remove(song);
		
		
	}

}
