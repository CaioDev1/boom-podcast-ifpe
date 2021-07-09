package com.boompodcast.categorias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Categories {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ColumnDefault("0")
	private Integer number_podcasts;
	@ColumnDefault("0")
	private Integer total_views;

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

	public Integer getNumber_podcasts() {
		return number_podcasts;
	}

	public void setNumber_podcasts(Integer number_podcasts) {
		this.number_podcasts = number_podcasts;
	}

	public Integer getTotal_views() {
		return total_views;
	}

	public void setTotal_views(Integer total_views) {
		this.total_views = total_views;
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
	
	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", number_podcasts=" + number_podcasts + ", total_views="
				+ total_views + "]";
	}
}