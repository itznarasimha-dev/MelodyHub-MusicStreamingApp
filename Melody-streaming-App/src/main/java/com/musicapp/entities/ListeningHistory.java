package com.musicapp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ListeningHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;
	
	private LocalDateTime played_at;
	
	private Integer duration_played_seconds;

	public ListeningHistory() {
		super();
	}

	public ListeningHistory(User user, Song song, LocalDateTime played_at, Integer duration_played_seconds) {
		super();
		this.user = user;
		this.song = song;
		this.played_at = played_at;
		this.duration_played_seconds = duration_played_seconds;
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

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public LocalDateTime getPlayed_at() {
		return played_at;
	}

	public void setPlayed_at(LocalDateTime played_at) {
		this.played_at = played_at;
	}

	public Integer getDuration_played_seconds() {
		return duration_played_seconds;
		
	}

	public void setDuration_played_seconds(Integer duration_played_seconds) {
		this.duration_played_seconds = duration_played_seconds;
	}
	
}
