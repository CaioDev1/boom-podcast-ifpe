package com.boompodcast.reacoes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boompodcast.podcasts.Podcasts;
import com.boompodcast.usuarios.Users;

@Repository
public interface ReactionsDao extends JpaRepository<Reactions, Integer> {
	//@Query("SELECT id FROM reactions WHERE ")
	public List<Reactions> findAllIdByUserAndPodcast(Users user, Podcasts podcast);
}
