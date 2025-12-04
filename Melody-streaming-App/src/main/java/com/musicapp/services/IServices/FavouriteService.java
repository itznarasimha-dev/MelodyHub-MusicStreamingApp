package com.musicapp.services.IServices;

import java.util.List;

import com.musicapp.entities.Favourite;

public interface FavouriteService {
    void addFavorite(Long userId, Long songId);

    void removeFavorite(Long userId, Long songId);

    boolean exists(Long userId, Long songId);

    List<Favourite> getFavorites(Long userId);
}
