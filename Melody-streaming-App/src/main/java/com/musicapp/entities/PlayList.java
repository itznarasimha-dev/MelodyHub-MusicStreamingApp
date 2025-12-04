package com.musicapp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class PlayList {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(nullable=false)
	private String name;
	
	private String desription;
	
	private LocalDateTime created_at=LocalDateTime.now();
	
	@OneToMany(mappedBy = "playlist", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<PlayListSong> songs;

	public PlayList() {
		super();
	}

	public PlayList( User user, String name, String desription, LocalDateTime created_at,
			List<PlayListSong> songs) {
		super();
		
		this.user = user;
		this.name = name;
		this.desription = desription;
		this.created_at = created_at;
		this.songs = songs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<PlayListSong> getSongs() {
		return songs;
	}

	public void setSongs(List<PlayListSong> songs) {
		this.songs = songs;
	}
	
	
	

}
