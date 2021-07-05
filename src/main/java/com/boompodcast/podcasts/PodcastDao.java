package com.boompodcast.podcasts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastDao extends JpaRepository<Podcasts, Integer> {
	public List<Podcasts> findAllByUserContaining(Integer user_id);
}
