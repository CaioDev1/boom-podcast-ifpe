package com.boompodcast.podcasts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boompodcast.categorias.Categories;
import com.boompodcast.categorias.CategoriesDao;

@Controller
public class PodcastController {

	@Autowired
	private PodcastDao podcastDao;
	private CategoriesDao categoriesDao;
	
	@PostMapping("/add-podcast")
	public String salvarPodcast(Podcasts podcast, @RequestParam("form_cover_file") MultipartFile form_cover_file, 
			@RequestParam("form_categories_id") Integer form_categories_id) {
		System.out.println(form_cover_file.getOriginalFilename());
		System.out.println(form_cover_file.getSize());
		
		Categories c = this.categoriesDao.getOne(form_categories_id);
		
		podcast.setCategories(c);
		
		// this.podcastDao.save(podcast);
		System.out.println(podcast);
		return "home";
	}
}
