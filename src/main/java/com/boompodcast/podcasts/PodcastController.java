package com.boompodcast.podcasts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PodcastController {

	@Autowired
	private PodcastDao podcastDao;
	
	@PostMapping("/add-podcast")
	public String salvarPodcast(Podcasts podcast) {
		this.podcastDao.save(podcast);
		System.out.println(podcast);
		return "home";
	}
}
