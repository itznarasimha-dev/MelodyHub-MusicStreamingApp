package com.musicapp.services.IServices;

import java.util.List;

import com.musicapp.entities.ListeningHistory;

public interface ListeningHistoryService {
	
	void recordPlay(Long userId, Long songId, int durationPlayed);

    List<ListeningHistory> findByUser(Long userId);

}
