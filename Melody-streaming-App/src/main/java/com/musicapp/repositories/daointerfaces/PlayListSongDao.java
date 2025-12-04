package com.musicapp.repositories.daointerfaces;

import java.util.List;

import com.musicapp.entities.PlayListSong;


public interface PlayListSongDao {
	
	void save(PlayListSong playListSong);



    void delete(Long id);

    PlayListSong  findById(Long id);


 
    List<PlayListSong> findAllByPlayListId(Long playListId);
    
    boolean exists(Long playlistId, Long songId);
    
}
