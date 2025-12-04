package com.musicapp.repositories.daointerfaces;

import java.util.List;

import com.musicapp.entities.PlayList;



public interface PlayListDao {

	void save(PlayList playList);

    void update(PlayList playList);

    void delete(Long id);

    PlayList  findById(Long id);

    List<PlayList> findAll();

    List<PlayList> findAllByUserId(Long userId);
    
	
}
