package BoomPodcast.ifpe.pp2.podcast;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import BoomPodcast.ifpe.pp2.acesso.Usuario;
@Entity
public class Podcast {
	@Id
	private Integer id; 
	private String name;	
	private String description;
	private String cover_path;
	private Categorias categories;
	@ManyToOne
	private Usuario user;
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
	public Categorias getCategories() {
		return categories;
	}
	public void setCategories(Categorias categories) {
		this.categories = categories;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
}
