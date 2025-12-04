package com.musicapp.services.IServices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.musicapp.entities.Song;

public interface SongService {
	
	void saveSongWithFiles(Song song,MultipartFile mp3,MultipartFile cover);
	
	Song findById(Long id);
	
	List<Song> findAll();
	
	List<Song> search(String query);
	
	List<Song> findByCategory(Long CategoryId);
	
	void delete(Long id);
	
	
}
