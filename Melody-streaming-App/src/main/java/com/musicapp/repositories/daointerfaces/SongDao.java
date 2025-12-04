package com.musicapp.repositories.daointerfaces;

import java.util.List;

import com.musicapp.entities.Song;



public interface SongDao {

	void save(Song song);

    void update(Song song);


    Song findById(Long id);

    List<Song> findAll();
    
    List<Song> searchByTitle(String title);

    List<Song> searchByArtist(String artist);

    List<Song> findByCategory(Long categoryId);
	
    void delete(Long id);
}
