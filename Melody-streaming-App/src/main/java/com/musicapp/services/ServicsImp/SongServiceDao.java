package com.musicapp.services.ServicsImp;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.musicapp.entities.Song;
import com.musicapp.repositories.daoimplementations.SongDaoImp;
import com.musicapp.services.IServices.SongService;

import jakarta.servlet.ServletContext;


@Service
@Transactional
public class SongServiceDao implements SongService{
	
	private final SongDaoImp songDao;
	
	@Autowired
	private  ServletContext context;
	
	public SongServiceDao(SongDaoImp songDao) {
		this.songDao=songDao;
	}
	
	@Override
	public void saveSongWithFiles(Song song, MultipartFile mp3, MultipartFile cover) {
		// TODO Auto-generated method stub
		String UPLOAD_DIR="c:/uploads";
		
		try {
			File folder=new File(UPLOAD_DIR);
			
			if(!folder.exists())folder.mkdirs();
			
			if(!mp3.isEmpty()) {
				String mp3name=mp3.getOriginalFilename();
				File dest=new File(folder,mp3name);
				
				mp3.transferTo(dest);
				song.setFilePath("/uploads/"+mp3name);
			}
			if(!cover.isEmpty()) {
				String covername=cover.getOriginalFilename();
				File dest=new File(folder,covername);
				cover.transferTo(dest);
				song.setCoverPath("/uploads/"+covername);
			}
			
			songDao.save(song);
			
		}
		catch (Exception e) {
		    e.printStackTrace();
		    throw new RuntimeException("File upload error: " + e.getMessage());
		}
		
	}

	@Override
	public Song findById(Long id) {
		// TODO Auto-generated method stub
		return songDao.findById(id);
	}

	@Override
	public List<Song> findAll() {
		// TODO Auto-generated method stub
		return songDao.findAll();
	}

	@Override
	public List<Song> search(String query) {
		// TODO Auto-generated method stub
		List<Song> byTitle=songDao.searchByTitle(query);
		if(!byTitle.isEmpty())return byTitle;
		
		return songDao.searchByArtist(query);
	}

	@Override
	public List<Song> findByCategory(Long CategoryId) {
		// TODO Auto-generated method stub
		return songDao.findByCategory(CategoryId);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		songDao.delete(id);
		
	}

}
