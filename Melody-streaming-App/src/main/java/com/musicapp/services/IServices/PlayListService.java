package com.musicapp.services.IServices;

import java.util.List;

import com.musicapp.entities.PlayList;
import com.musicapp.entities.PlayListSong;

public interface PlayListService {
	
	void createPlayList(Long userId,String name);
	
	PlayList findById(Long id);
	
	List<PlayList> findByUser(Long userId);
	
	void addSong(Long playListId,Long songId);
	
	List<PlayListSong> getSongs(Long playListId);
	
	void removeSong(Long playListSongId);
	
	void delete(Long playListId);

}
