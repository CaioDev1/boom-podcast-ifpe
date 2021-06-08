package com.boompodcast.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Podcasts {

	@ManyToOne
	@JoinColumn(name = "categories_id")
	private Categories categories;
}
