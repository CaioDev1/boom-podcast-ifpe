package com.boompodcast.reacoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.boompodcast.episodios.Episodes;
import com.boompodcast.podcasts.Podcasts;
import com.boompodcast.usuarios.Users;

@Entity
public class Reactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "podcast_id")
	private Podcasts podcast;
	@ManyToOne
	@JoinColumn(name = "episode_id")
	private Episodes episode;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	private Integer value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Podcasts getPodcast() {
		return this.podcast;
	}
	public void setPodcast(Podcasts podcast) {
		this.podcast = podcast;
	}
	public Episodes getEpisode() {
		return episode;
	}
	public void setEpisode(Episodes episode) {
		this.episode = episode;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Reactions [id=" + id + ", podcast=" + podcast + ", episode=" + episode + ", user="
				+ user + ", value=" + value + "]";
	}
}