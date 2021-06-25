package com.boompodcast.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Podcasts {
	@Id
	private Integer id; 
	private String name;	
	private String description;
	private String cover_path;
	@ManyToOne
	@JoinColumn(name = "categories_id")
	private Categories categories;
	@ManyToOne
	private Users user_id;
	
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
	public Categories getCategories() {
		return categories;
	}
	public void setCategoria(Categories categoria) {
		this.categories = categoria;
	}
	public Users getUserId() {
		return user_id;
	}
	public void setUserId(Users user) {
		this.user_id = user;
	}
	
	
	
}
