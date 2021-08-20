package com.boompodcast.levels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Levels {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String color;
	private String description;
	private String requirements;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	
	@Override
	public String toString() {
		return "Levels [id=" + id + ", color=" + color + ", description=" + description + ", requirements="
				+ requirements + "]";
	}
}