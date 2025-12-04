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
public class Favourite {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	
	    @ManyToOne
	    @JoinColumn(name = "song_id", nullable = false)
	    private Song song;
	
	    private LocalDateTime addedAt = LocalDateTime.now();

		public Favourite() {
			super();
		}

		public Favourite(User user, Song song, LocalDateTime addedAt) {
			super();
			this.user = user;
			this.song = song;
			this.addedAt = addedAt;
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

		public LocalDateTime getAddedAt() {
			return addedAt;
		}

		public void setAddedAt(LocalDateTime addedAt) {
			this.addedAt = addedAt;
		}
	
	    
	    
}
