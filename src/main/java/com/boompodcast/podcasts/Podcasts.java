package com.boompodcast.podcasts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.boompodcast.categorias.Categories;
import com.boompodcast.usuarios.Users;
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
	@JoinColumn(name = "user_id")
	private Users user;

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
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
