package com.boompodcast.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Podcast podcast_id;
	@ManyToOne
	private Episode episode_id;
	@ManyToOne
	private User user_id;
	private int value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPodcast_id() {
		return this.podcast_id;
	}
	public void setPodcast_id(int podcast_id) {
		this.podcast_id = podcast_id;
	}
	public int getEpisode_id() {
		return episode_id;
	}
	public void setEpisode_id(int episode_id) {
		this.episode_id = episode_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Reactions [id=" + id + ", podcast_id=" + podcast_id + ", episode_id=" + episode_id + ", user_id="
				+ user_id + ", value=" + value + "]";
	}
}
