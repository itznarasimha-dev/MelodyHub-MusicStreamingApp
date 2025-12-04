package com.musicapp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Song {
	

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false, length = 200)
		private String title;
		
		@Column(nullable = false, length = 150)
		private String artist;
		
		@Column(length = 150)
		private String album;
		
		@Column(length = 100)
		private String genre;
		
		private Integer durationSeconds;
		
		@Column(length = 255)
		private String filePath;
		
		@Column(length = 255)
		private String coverPath;
		
		@ManyToOne
		@JoinColumn(name = "category_id",nullable=true)
		private Category category;

		private LocalDateTime createdAt = LocalDateTime.now();

		public Song() {
			super();
		}

		public Song(String title, String artist, String album, String genre, Integer durationSeconds, String filePath,
				String coverPath, Category category, LocalDateTime createdAt) {
			super();
			this.title = title;
			this.artist = artist;
			this.album = album;
			this.genre = genre;
			this.durationSeconds = durationSeconds;
			this.filePath = filePath;
			this.coverPath = coverPath;
			this.category = category;
			this.createdAt = createdAt;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public String getAlbum() {
			return album;
		}

		public void setAlbum(String album) {
			this.album = album;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public Integer getDurationSeconds() {
			return durationSeconds;
		}

		public void setDurationSeconds(Integer durationSeconds) {
			this.durationSeconds = durationSeconds;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getCoverPath() {
			return coverPath;
		}

		public void setCoverPath(String coverPath) {
			this.coverPath = coverPath;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
	
		
	

}
