package com.boompodcast.episodios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boompodcast.podcasts.Podcasts;

public interface EpisodesDao extends JpaRepository<Episodes, Integer> {
	public List<Episodes> findAllByPodcast(Podcasts podcast);
}

