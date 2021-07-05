package com.boompodcast.episodios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boompodcast.podcasts.PodcastDao;
import com.boompodcast.podcasts.Podcasts;

import app_paths.AppPaths;

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
				byte[] bytes = form_audio_file.getBytes();
				String newAudioFileName = String.valueOf(episode.getId()) + "_" + form_audio_file.getOriginalFilename();
				
				Path audioFilePath = Paths.get(AppPaths.audiosFolderPath + newAudioFileName);
				Files.write(audioFilePath, bytes);
				
				episode.setAudio(newAudioFileName);
				
				this.episodesDao.save(episode);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/adm/home";
	}
}
