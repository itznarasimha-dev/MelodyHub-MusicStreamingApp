package com.musicapp.services.ServicsImp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicapp.entities.PlayList;
import com.musicapp.entities.PlayListSong;
import com.musicapp.entities.Song;
import com.musicapp.entities.User;
import com.musicapp.repositories.daoimplementations.PlayListDaoImp;
import com.musicapp.repositories.daointerfaces.PlayListDao;
import com.musicapp.repositories.daointerfaces.PlayListSongDao;
import com.musicapp.repositories.daointerfaces.SongDao;
import com.musicapp.repositories.daointerfaces.UserDao;
import com.musicapp.services.IServices.PlayListService;

@Service
@Transactional
public class PlayListServiceDao implements PlayListService{
	
	private final PlayListDao playListDao;
	
	private final UserDao userDao;
	private final SongDao songDao;
	private final PlayListSongDao playListSongDao;
	
	public PlayListServiceDao(PlayListDao playListDao,UserDao userDao, SongDao songDao,PlayListSongDao playListSongDao) {
		this.playListDao=playListDao;
		this.userDao=userDao;
		this.songDao=songDao;
		this.playListSongDao=playListSongDao;
	}

	@Override
	public void createPlayList(Long userId, String name) {
		// TODO Auto-generated method stub
		
		 User user = userDao.findById(userId);
				
		PlayList playlist = new PlayList();
		playlist.setName(name);
		playlist.setUser(user);
		
		playListDao.save(playlist);
		
	}

	@Override
	public PlayList findById(Long id) {
		// TODO Auto-generated method stub
		return playListDao.findById(id);
	}

	@Override
	public List<PlayList> findByUser(Long userId) {
		// TODO Auto-generated method stub
		return playListDao.findAllByUserId(userId);
	}

	@Override
	public void addSong(Long playListId, Long songId) {
		// TODO Auto-generated method stub
		if(playListSongDao.exists(playListId, songId))
			return;
		
		PlayList PlayList=playListDao.findById(playListId);
		
		Song song=songDao.findById(songId);
		
		PlayListSong ps=new PlayListSong();
		ps.setPlaylist(PlayList);
		ps.setSong(song);
		int pos=playListSongDao.findAllByPlayListId(playListId).size()+1;
		ps.setPosition(pos);
		
		playListSongDao.save(ps);
		
	}

	@Override
	public List<PlayListSong> getSongs(Long playListId) {
		// TODO Auto-generated method stub
		return playListSongDao.findAllByPlayListId(playListId);
	}

	@Override
	public void removeSong(Long playListSongId) {
		// TODO Auto-generated method stub
		playListSongDao.delete(playListSongId);
		
	}

	@Override
	public void delete(Long playListId) {
		// TODO Auto-generated method stub
		playListSongDao.delete(playListId);
	}
       
}
