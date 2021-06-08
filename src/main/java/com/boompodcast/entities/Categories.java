package com.boompodcast.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categories implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int number_podcasts;
	private int total_views;
	
	@OneToMany(mappedBy = "categories")
	private List<Podcasts> podcasts = new ArrayList<>();

	public Categories() {
	}

	public Categories(Integer id, String name, int number_podcasts, int total_views, List<Podcasts> podcasts) {
		super();
		this.id = id;
		this.name = name;
		this.number_podcasts = number_podcasts;
		this.total_views = total_views;
		this.podcasts = podcasts;
	}

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

	public int getNumber_podcasts() {
		return number_podcasts;
	}

	public void setNumber_podcasts(int number_podcasts) {
		this.number_podcasts = number_podcasts;
	}

	public int getTotal_views() {
		return total_views;
	}

	public void setTotal_views(int total_views) {
		this.total_views = total_views;
	}

	public List<Podcasts> getPodcasts() {
		return podcasts;
	}

	public void setPodcasts(List<Podcasts> podcasts) {
		this.podcasts = podcasts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categories other = (Categories) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
