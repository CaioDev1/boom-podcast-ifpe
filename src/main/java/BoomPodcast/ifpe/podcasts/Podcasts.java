package BoomPodcast.ifpe.podcasts;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import BoomPodcast.ifpe.categorias.Categories;
import BoomPodcast.ifpe.usuarios.Users;
@Entity
public class Podcasts {
	@Id
	private Integer id; 
	private String name;	
	private String description;
	private String cover_path;
	@ManyToOne
	private Categories categories;
	@ManyToOne
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
