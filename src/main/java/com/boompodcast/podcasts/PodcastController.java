package com.boompodcast.podcasts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boompodcast.categorias.Categories;
import com.boompodcast.categorias.CategoriesDao;
import com.boompodcast.usuarios.Users;

import app_paths.AppPaths;

@Controller
public class PodcastController {

	@Autowired
	private PodcastDao podcastDao;
	@Autowired
	private CategoriesDao categoriesDao;
	
	@PostMapping("/add-podcast")
	public String salvarPodcast(Podcasts podcast, @RequestParam("form_cover_file") MultipartFile form_cover_file, 
			@RequestParam("form_categories_id") Integer form_categories_id, HttpServletRequest request) {		
		Categories c = this.categoriesDao.getOne(form_categories_id);
		podcast.setCategories(c);
		
		Users usuarioLogado = (Users)request.getSession().getAttribute("usuarioLogado");
		podcast.setUser(usuarioLogado);
		
		this.podcastDao.saveAndFlush(podcast);
		
		try {
			if(!form_cover_file.isEmpty()) {
				byte[] bytes = form_cover_file.getBytes();
				String newCoverFileName = String.valueOf(podcast.getId()) + "_" + form_cover_file.getOriginalFilename();
				
				Path podcastCoverFilePath = Paths.get(AppPaths.coverFolderPath + newCoverFileName);
				Files.write(podcastCoverFilePath, bytes);
				
				podcast.setCover(newCoverFileName);
				
				this.podcastDao.save(podcast);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/adm/home";
	}
}
