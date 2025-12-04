package com.musicapp.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class PlayListSong {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="playlist_id", nullable=false)
	private PlayList playlist;
	
	@ManyToOne
	@JoinColumn(name="sond_id", nullable=false)
	private Song song;
	
	private Integer position;
	
	private LocalDate added_at;

	public PlayListSong() {
		super();
	}

	public PlayListSong(PlayList playlist, Song song, Integer position, LocalDate added_at) {
		super();
		this.playlist = playlist;
		this.song = song;
		this.position = position;
		this.added_at = added_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlayList getPlaylist() {
		return playlist;
	}

	public void setPlaylist(PlayList playlist) {
		this.playlist = playlist;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public LocalDate getAdded_at() {
		return added_at;
	}

	public void setAdded_at(LocalDate added_at) {
		this.added_at = added_at;
	}
	
	
	
}
