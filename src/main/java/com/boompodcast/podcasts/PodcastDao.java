package com.boompodcast.podcasts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastDao extends JpaRepository<Podcasts, Integer> {

}
