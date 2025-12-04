package com.musicapp.repositories.daointerfaces;

import java.util.List;

import com.musicapp.entities.ListeningHistory;

public interface ListenHistoryDao {
	
	
    void save(ListeningHistory history);

    List<ListeningHistory> findByUserId(Long userId);

    List<ListeningHistory> findRecentByUserId(Long userId);

}
