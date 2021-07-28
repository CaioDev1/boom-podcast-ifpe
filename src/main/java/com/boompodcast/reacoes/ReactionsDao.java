package com.boompodcast.reacoes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boompodcast.episodios.Episodes;
import com.boompodcast.podcasts.Podcasts;
import com.boompodcast.usuarios.Users;

@Repository
public interface ReactionsDao extends JpaRepository<Reactions, Integer> {
	public List<ProjectId> findAllEpisodeIdByUserAndPodcast(Users user, Podcasts podcast);
	
	public boolean existsByEpisodeAndUser(Episodes episode, Users user);
	
	@Transactional
	public void deleteByEpisode(Episodes episode);
	
	public List<Reactions> findAllByUser(Users user);
}
