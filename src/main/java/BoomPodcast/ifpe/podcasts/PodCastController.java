package BoomPodcast.ifpe.pp2.podcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PodCastController {

	@Autowired
	private PodcastDao podcastDao;
	
	@PostMapping("/salvarpodcast")
	public String salvarPodcast(Podcast podcast) {
		this.podcastDao.save(podcast);
		System.out.println(podcast);
		return "home";
	}
}
