package com.musicapp.services.ServicsImp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicapp.entities.ListeningHistory;
import com.musicapp.entities.Song;
import com.musicapp.entities.User;
import com.musicapp.repositories.daointerfaces.ListenHistoryDao;
import com.musicapp.services.IServices.ListeningHistoryService;

@Service
@Transactional
public class ListeningHistoryServiceDao implements ListeningHistoryService {

	   private final ListenHistoryDao historyDAO;

	    public ListeningHistoryServiceDao(ListenHistoryDao historyDAO) {
	        this.historyDAO = historyDAO;
	    }
	
	@Override
	public void recordPlay(Long userId, Long songId, int durationPlayed) {
		// TODO Auto-generated method stub
		
		   ListeningHistory h = new ListeningHistory();

	        User u = new User();
	        u.setId(userId);

	        Song s = new Song();
	        s.setId(songId);

	        h.setUser(u);
	        h.setSong(s);
	        h.setDuration_played_seconds(durationPlayed);
	        h.setPlayed_at(LocalDateTime.now());

	        historyDAO.save(h);
		
	}

	@Override
	public List<ListeningHistory> findByUser(Long userId) {
		// TODO Auto-generated method stub
		  return historyDAO.findByUserId(userId);
	}

}
