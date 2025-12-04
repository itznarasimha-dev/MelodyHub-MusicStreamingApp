package com.musicapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicapp.entities.User;
import com.musicapp.services.IServices.PlayListService;
import com.musicapp.services.IServices.SongService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {

	private final PlayListService playlistService;
    private final SongService songService;

    public PlaylistController(PlayListService playlistService, SongService songService) {
        this.playlistService = playlistService;
        this.songService = songService;
    }
	
    @GetMapping("/my")
    public String myPlaylists(HttpSession session,Model model) {
    	User user=(User)session.getAttribute("user");
    	model.addAttribute("playLists",playlistService.findByUser(user.getId()));
    	return "playList";
    }
    
    @GetMapping("/create")
    public String createPlayListForm() {
    	return "create_playList";
    }
    
    @PostMapping("/create")
    public String createPlayList(@RequestParam String name,HttpSession session) {
    	User user=(User)session.getAttribute("user");
    	playlistService.createPlayList(user.getId(), name);
    	return "redirect:/playlist/my";
    }
    
    @GetMapping("/{id}")
    public String viewPlaylist(@PathVariable Long id, Model model) {
        model.addAttribute("playlist", playlistService.findById(id));
        model.addAttribute("songs", playlistService.getSongs(id));
        return "playList_view";
    }
    
    @PostMapping("/{pid}/add/{sid}")
    public String addSong(@PathVariable Long pid, @PathVariable Long sid) {
        playlistService.addSong(pid, sid);
        return "redirect:/playlist/" + pid;
        
    }
    
    @PostMapping("/{pid}/remove/{psid}")
    public String removeSong(@PathVariable Long pid, @PathVariable Long psid) {
        playlistService.removeSong(psid);
        return "redirect:/playlist/" + pid;
    }

    @PostMapping("/delete/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        playlistService.delete(id);
        return "redirect:/playlist/my";
    }
    
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            