package com.boompodcast.podcasts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boompodcast.categorias.Categories;
import com.boompodcast.usuarios.Users;

@Repository
public interface PodcastDao extends JpaRepository<Podcasts, Integer> {
	public List<Podcasts> findAllByUser(Users user);
	
	public List<Podcasts> findAllByCategories(Categories categories);
}
