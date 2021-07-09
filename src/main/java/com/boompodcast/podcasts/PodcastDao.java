package com.boompodcast.podcasts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boompodcast.usuarios.Users;

public interface PodcastDao extends JpaRepository<Podcasts, Integer> {
	public List<Podcasts> findAllByUser(Users user);
}
