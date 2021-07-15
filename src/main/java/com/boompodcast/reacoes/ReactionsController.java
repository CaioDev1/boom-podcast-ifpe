package com.boompodcast.reacoes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boompodcast.episodios.Episodes;
import com.boompodcast.episodios.EpisodesDao;
import com.boompodcast.usuarios.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class ReactionsController {
	@Autowired
	private ReactionsDao reactionsDao;
	@Autowired
	private EpisodesDao episodesDao;
	
	@PostMapping("/reaction")
	public ResponseEntity<Object> handleReaction(Integer form_episode_id, HttpServletRequest request) {
		Users usuarioLogado = (Users)request.getSession().getAttribute("usuarioLogado");
		Episodes episode = this.episodesDao.getOne(form_episode_id);
		
		boolean userReactionExists = this.reactionsDao.existsByEpisodeAndUser(episode, usuarioLogado);
	
		ObjectNode response = new ObjectMapper().createObjectNode();

		if(userReactionExists) {
			this.reactionsDao.deleteByEpisode(episode);
			
			this.episodesDao.decrementEpisodeReactions(form_episode_id);
			
			response.put("like", false);
		} else {
			Reactions newReaction = new Reactions(episode.getPodcast(), episode, usuarioLogado);
			this.reactionsDao.save(newReaction);
			
			this.episodesDao.incrementEpisodeReactions(form_episode_id);
			
			response.put("like", true);
		}
				
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
