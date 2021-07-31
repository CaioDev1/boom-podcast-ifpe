package com.boompodcast.episodios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boompodcast.podcasts.Podcasts;

@Repository
public interface EpisodesDao extends JpaRepository<Episodes, Integer> {
	public List<Episodes> findAllByPodcast(Podcasts podcast);
	
	public Integer countByPodcastIn(List<Podcasts> podcasts);
	
	public List<ProjectPodcast> findDistinctTop15ByOrderByViewsDesc();

	public List<ProjectPodcast> findDistinctTop15ByOrderByCreatedAtDesc();
	
	public List<ProjectPodcast> findDistinctTop15ByOrderByReactionsValueDesc();
	
	@Transactional
	@Modifying
	@Query("UPDATE Episodes t SET t.reactionsValue = t.reactionsValue + 1 WHERE t.id = :episodeId")
	public void incrementEpisodeReactions(@Param("episodeId") Integer episodeId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Episodes t SET t.reactionsValue = t.reactionsValue - 1 WHERE t.id = :episodeId")
	public void decrementEpisodeReactions(@Param("episodeId") Integer episodeId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Episodes t SET t.views = t.views + 1 WHERE t.id = :episodeId")
	public void incrementViews(@Param("episodeId") Integer episodeId);
	
}

