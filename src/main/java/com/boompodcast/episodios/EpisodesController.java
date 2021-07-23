package com.boompodcast.episodios;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boompodcast.podcasts.PodcastDao;
import com.boompodcast.podcasts.Podcasts;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import firebase.FirebaseController;

@Controller
public class EpisodesController {
	@Autowired
	EpisodesDao episodesDao;
	@Autowired
	PodcastDao podcastDao;
	
	@PostMapping("/add-episode")
	public String salvarEpisodio(Episodes episode, @RequestParam("form_audio_file") MultipartFile form_audio_file,
			@RequestParam("form_podcast_id") Integer form_podcast_id) {
		Podcasts p = this.podcastDao.getOne(form_podcast_id);
		episode.setPodcast(p);
		
		this.episodesDao.saveAndFlush(episode);
		
		try {
			if(!form_audio_file.isEmpty()) {
				String newAudioFileName = String.valueOf(episode.getId()) + "_" + form_audio_file.getOriginalFilename();
				
				String audio_file_url = FirebaseController.uploadFile(form_audio_file, newAudioFileName, "audios/");
				
				episode.setAudio(audio_file_url);
				
				this.episodesDao.save(episode);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/adm/home";
	}
	
	@PostMapping("/add-view")
	public ResponseEntity<Object> incrementEpisodeView(Integer form_episode_id) {		
		this.episodesDao.incrementViews(form_episode_id);
		
		ObjectNode response = new ObjectMapper().createObjectNode();
		response.put("result", "View added successfully.");
		
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
