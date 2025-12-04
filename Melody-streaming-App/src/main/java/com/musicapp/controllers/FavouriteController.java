package com.musicapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicapp.entities.User;
import com.musicapp.services.IServices.FavouriteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/favourites")
public class FavouriteController {

	
	private final FavouriteService favoriteService;

    public FavouriteController(FavouriteService favoriteService) {
        this.favoriteService = favoriteService;
    }
    
    @GetMapping("/my")
    public String favourites(HttpSession session,Model model) {
    	User user=(User) session.getAttribute("user");
    	model.addAttribute("favourite",favoriteService.getFavorites(user.getId()));
    	return "favourites";
    	
    }
    
    @PostMapping("/add/{songId}")
    public String addFavorite(@PathVariable Long songId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        favoriteService.addFavorite(user.getId(), songId);
        return "redirect:/favourites/my";
    }
    
    @PostMapping("/remove/{songId}")
    public String removeFavorite(@PathVariable Long songId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        favoriteService.removeFavorite(user.getId(), songId);
        return "redirect:/favourites/my";
    }
    
	
}
