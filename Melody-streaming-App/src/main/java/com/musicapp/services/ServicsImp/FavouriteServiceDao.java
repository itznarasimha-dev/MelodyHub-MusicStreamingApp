package com.musicapp.services.ServicsImp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicapp.entities.Favourite;
import com.musicapp.entities.Song;
import com.musicapp.entities.User;
import com.musicapp.repositories.daointerfaces.FavouriteDao;
import com.musicapp.services.IServices.FavouriteService;

@Service
@Transactional
public class FavouriteServiceDao implements FavouriteService{
	
	private final FavouriteDao favouritedao;

    public FavouriteServiceDao(FavouriteDao favouritedao) {
        this.favouritedao = favouritedao;
    }

	@Override
	public void addFavorite(Long userId, Long songId) {
		// TODO Auto-generated method stub
		 if (favouritedao.exists(userId, songId)) return;

	        Favourite f = new Favourite();

	        User u = new User();
	        u.setId(userId);

	        Song s = new Song();
	        s.setId(songId);

	        f.setUser(u);
	        f.setSong(s);

	        favouritedao.save(f);
		
	}

	@Override
	public void removeFavorite(Long userId, Long songId) {
		// TODO Auto-generated method stub
		favouritedao.delete(userId, songId);
	}

	@Override
	public boolean exists(Long userId, Long songId) {
		// TODO Auto-generated method stub
		return favouritedao.exists(userId, songId);
	}

	@Override
	public List<Favourite> getFavorites(Long userId) {
		// TODO Auto-generated method stub
		return favouritedao.findByUserId(userId);
	}

}
