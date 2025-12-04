package com.musicapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.musicapp.entities.Category;
import com.musicapp.entities.Song;
import com.musicapp.services.IServices.CategoryService;
import com.musicapp.services.IServices.SongService;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "http://localhost:3000")
public class SongController {
	
	 private final SongService songService;
	    private final CategoryService categoryService;

	    public SongController(SongService songService, CategoryService categoryService) {
	        this.songService = songService;
	        this.categoryService = categoryService;
	    }
	    
	    @GetMapping("/list")
	    public List<Song> listSongs() {
	       return songService.findAll();
	    }
	    
	    @GetMapping("/search")
	    public List<Song> searchSongs(@RequestParam("q") String query) {
	    	return songService.search(query);
	    }
	    
	    @GetMapping("/add")
	    public List<Category> addSongForm() {
	       return categoryService.findAll();
	    }
	    
	    
	    @PostMapping("/add")
	    public void addSong(@ModelAttribute Song song,
	    		@RequestParam MultipartFile file,
	    		@RequestParam MultipartFile cover) {
	    	
	    	try {
	    		songService.saveSongWithFiles(song, file, cover);
	    		
	    	}catch (Exception e) {
	    	    e.printStackTrace();
	    	    throw new RuntimeException("File upload error: " + e.getMessage());
	    	}
	    	
	    	
	    }
	    
	    @GetMapping("/{id}")
	    public Song viewSong(@PathVariable Long id) {
	    	return songService.findById(id);
	    	
	    }
	    
	    

}
