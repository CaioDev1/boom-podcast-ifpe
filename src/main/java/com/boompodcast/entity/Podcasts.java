package com.boompodcast.entity;

import javax.persistence.ManyToOne;

public class Podcasts {

	@ManyToOne
	private Categories categories;
}
