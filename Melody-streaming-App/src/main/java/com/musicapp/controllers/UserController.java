package com.musicapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicapp.entities.User;
import com.musicapp.services.EmailService;
import com.musicapp.services.IServices.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	private final EmailService email;
	

    public UserController(UserService userService,EmailService email) {
        this.userService = userService;
        this.email=email;
    }
    
    @GetMapping("/register")
    public String showRegisterForm() {
    	return "register";
    }
    
    @PostMapping("/register")
    public String register( @ModelAttribute User user,Model model) {
    	String mail=user.getEmail();
    	if(userService.emailExist(mail)) {
    		model.addAttribute("error","Email already exists");
    		return "register";
    	}
    	userService.register(user);
    	
    	email.sendMail(mail, "hello", "message text");
    	
    	model.addAttribute("msg","Registration Succesful !--please Login");
    	return "login";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String Login(@RequestParam String email,@RequestParam String password,HttpSession session,Model model) {
    	User user=userService.Login(email, password);
    	if(user==null) {
    		model.addAttribute("error :","invalid credentials..");
    		return"login";
    	}
    	session.setAttribute("user", user);
    	return "redirect:/songs/list";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/user/login";
    }

}
