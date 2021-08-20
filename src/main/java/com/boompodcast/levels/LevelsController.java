package com.boompodcast.levels;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.boompodcast.episodios.EpisodesDao;
import com.boompodcast.podcasts.PodcastDao;
import com.boompodcast.podcasts.Podcasts;
import com.boompodcast.reacoes.Reactions;
import com.boompodcast.reacoes.ReactionsDao;
import com.boompodcast.usuarios.Users;
import com.boompodcast.usuarios.UsersDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class LevelsController {
	@Autowired
	private PodcastDao podcastDao;
	@Autowired
	private EpisodesDao episodesDao;
	@Autowired
	private ReactionsDao reactionsDao;
	@Autowired
	private UsersDAO usersDao;
	@Autowired
	private LevelsDao levelsDao;
	
	@GetMapping("/user-level")
	public ResponseEntity<Object> getUserLevelStatus(HttpServletRequest request) {
		ObjectNode response = new ObjectMapper().createObjectNode();
		
		Users user = (Users)request.getSession().getAttribute("usuarioLogado");

		List<Podcasts> userPodcasts = this.podcastDao.findAllByUser(user);

		if(!userPodcasts.isEmpty()) {
			Integer userEpisodesLength = this.episodesDao.countByPodcastIn(userPodcasts);
			
			List<Reactions> userReactions = this.reactionsDao.findAllByUser(user);
			
			List<Levels> currentLevels = this.levelsDao.findAll();
			int level = 0;
			
			if(userPodcasts.size() >= 2 && userEpisodesLength >= 2 && userReactions.size() >= 2) {
				level = 3;
			} else if(userPodcasts.size() >= 1 && userEpisodesLength >= 1 && userReactions.size() >= 1) {
				level = 2;
			}
		
			if(level > 0 && level != user.getLevel().getId()) {
				response.put("level", level);
				response.put("color", currentLevels.get(level - 1).getColor());
				response.put("description", currentLevels.get(level - 1).getDescription());
				
				for(Levels lvl : currentLevels) {
					if(lvl.getId() == level) {
						user.setLevel(lvl);
						
						this.usersDao.saveAndFlush(user);
						
						break;
					}
				}
				
				response.put("upgradedLevel", true);
				
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			}
		}
		
		response.put("upgrade", false);
		
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
