package com.boompodcast.podcasts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.boompodcast.categorias.Categories;
import com.boompodcast.usuarios.Users;
@Entity
public class Podcasts {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String name;	
	private String description;
	private String cover;
	@ManyToOne
	@JoinColumn(name = "categories_id", nullable = false)
	private Categories categories;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
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
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
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
	
	@Override
	public String toString() {
		return "Podcasts [id=" + id + ", name=" + name + ", description=" + description + ", cover=" + cover
				+ ", categories=" + categories + ", user=" + user + "]";
	}
}
