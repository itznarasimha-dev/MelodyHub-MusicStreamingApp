package com.musicapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicapp.entities.User;
import com.musicapp.services.IServices.ListeningHistoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/listeninghistory")
public class ListeningHistoryController {
	
	 private final ListeningHistoryService historyService;

	    public ListeningHistoryController(ListeningHistoryService historyService) {
	        this.historyService = historyService;
	    }

	    @GetMapping("/my")
	    public String myHistory(HttpSession session, Model model) {
	        User user = (User) session.getAttribute("user");
	        model.addAttribute("history", historyService.findByUser(user.getId()));
	        return "history";
	    }

	    @PostMapping
	    ("/track/{songId}")
	    public String track(@PathVariable Long songId,
	                        @RequestParam int duration,
	                        HttpSession session) {
	        User user = (User) session.getAttribute("user");
	        historyService.recordPlay(user.getId(), songId, duration);
	        return "redirect:/songs/" + songId;
	    }

}
