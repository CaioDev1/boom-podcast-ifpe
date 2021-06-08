package com.boompodcast.entities;

import javax.persistence.ManyToOne;

public class Podcasts {

	@ManyToOne
	private Categories categories;
}
