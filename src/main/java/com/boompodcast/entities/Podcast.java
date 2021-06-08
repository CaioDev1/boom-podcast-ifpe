package com.boompodcast.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import boomPodcast.ifpe.pp2.podcast.Category;
import boomPodcast.ifpe.pp2.user.User;
@Entity
public class Podcast {
	@Id
	private Integer id; 
	private String name;	
	private String description;
	private String cover_path;
	
	@ManyToOne
	private Categories categoria;
	@ManyToOne
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCover_path() {
		return cover_path;
	}
	public void setCover_path(String cover_path) {
		this.cover_path = cover_path;
	}
	public Categories getCategoria() {
		return categoria;
	}
	public void setCategoria(Categories categoria) {
		this.categoria = categoria;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
