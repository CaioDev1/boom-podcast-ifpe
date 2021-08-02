package com.boompodcast.categorias;

import javax.persistence.Column;
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
	@Column(name = "number_podcasts")
	private Integer numberPodcasts;
	@ColumnDefault("0")
	@Column(name = "total_views")
	private Integer totalViews;

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

	public Integer getNumberPodcasts() {
		return numberPodcasts;
	}

	public void setNumber_podcasts(Integer numberPodcasts) {
		this.numberPodcasts = numberPodcasts;
	}

	public Integer getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(Integer totalViews) {
		this.totalViews = totalViews;
	}
	
	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", numberPodcasts=" + numberPodcasts + ", totalViews="
				+ totalViews + "]";
	}
}