package com.musicapp.repositories.daointerfaces;

import java.util.List;

import com.musicapp.entities.Favourite;

public interface FavouriteDao {
	
    void save(Favourite favorite);

    void delete(Long userId, Long songId);

    boolean exists(Long userId, Long songId);

    List<Favourite> findByUserId(Long userId);

    
}
