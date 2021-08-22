package com.boompodcast.acesso;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boompodcast.categorias.Categories;
import com.boompodcast.categorias.CategoriesDao;
import com.boompodcast.episodios.Episodes;
import com.boompodcast.episodios.EpisodesDao;
import com.boompodcast.episodios.ProjectPodcast;
import com.boompodcast.levels.Levels;
import com.boompodcast.levels.LevelsDao;
import com.boompodcast.podcasts.PodcastDao;
import com.boompodcast.podcasts.PodcastRow;
import com.boompodcast.podcasts.Podcasts;
import com.boompodcast.reacoes.ReactionsDao;
import com.boompodcast.reacoes.ReactionsUtils;
import com.boompodcast.usuarios.Users;
import com.boompodcast.usuarios.UsersDAO;

@Controller
public class AcessoController {

	@Autowired
	private UsersDAO usuarioDAO;
	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private PodcastDao podcastsDao;
	@Autowired
	private EpisodesDao episodesDao;
	@Autowired
	private ReactionsDao reactionsDao;
	@Autowired
	private LevelsDao levelsDao;
	@Autowired
	private PasswordEncoder encoder;
	
	private List<Categories> categoriesList;
	private List<Levels> levelsList;
	
	@PostConstruct
	public void getCategories() {
		categoriesList = this.categoriesDao.findAll();
		levelsList = this.levelsDao.findAll();
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("page", "login");
		return "login";
	}
	 
	@GetMapping("/")
	public String cadastro(Model model) {
		model.addAttribute("page", "register");
		
		return "register";
	}
	
	@GetMapping("/adm/home")
	public String home(Model model) {
		model.addAttribute("page", "home");
		model.addAttribute("default_categories", categoriesList);
		
		List<ProjectPodcast> mostViewedPodcasts = this.episodesDao.findDistinctTop15ByOrderByViewsDesc();
		List<ProjectPodcast> mostRecentPodcasts = this.episodesDao.findDistinctTop15ByOrderByCreatedAtDesc();
		List<ProjectPodcast> mostLikedPodcasts = this.episodesDao.findDistinctTop15ByOrderByReactionsValueDesc();

		List<PodcastRow> podcastRows = new ArrayList<PodcastRow>();
		podcastRows.add(new PodcastRow("Mais visualizados", mostViewedPodcasts));
		podcastRows.add(new PodcastRow("Episódios mais recentes", mostRecentPodcasts));
		podcastRows.add(new PodcastRow("Podcasts mais curtidos", mostLikedPodcasts));
		
		model.addAttribute("podcastRows", podcastRows);
		
		return "home";
	}
	
	@GetMapping("/adm/usuario")
	public String usuario(Model model, HttpServletRequest request) {
		Users usuarioLogado = (Users)request.getSession().getAttribute("usuarioLogado");
		List<Podcasts> user_podcasts = this.podcastsDao.findAllByUser(usuarioLogado);
		
		model.addAttribute("page", "profile");
		model.addAttribute("categories", categoriesList);
		model.addAttribute("user_podcasts", user_podcasts);
		model.addAttribute("user", usuarioLogado);
		model.addAttribute("default_categories", categoriesList);
		model.addAttribute("levels", levelsList);
		
		return "profile";
	}

	@GetMapping("/adm/podcast/{podcast_id}")
	public String podcast(Model model, @PathVariable Integer podcast_id, HttpServletRequest request) {
		Podcasts podcast = this.podcastsDao.getOne(podcast_id);
		List<Episodes> episodes = this.episodesDao.findAllByPodcast(podcast);
		
		Users podcastOwner = this.usuarioDAO.getOne(podcast.getUser().getId());
		
		Users usuarioLogado = (Users)request.getSession().getAttribute("usuarioLogado");
		List<Integer> reactionsIdList = ReactionsUtils.projectionToList(
			this.reactionsDao.findAllEpisodeIdByUserAndPodcast(usuarioLogado, podcast)
		);
				
		model.addAttribute("page", "podcast");
		model.addAttribute("podcast", podcast);
		model.addAttribute("episodes", episodes);
		model.addAttribute("user", podcastOwner);
		model.addAttribute("user_reactions", reactionsIdList);
		model.addAttribute("default_categories", categoriesList);
		model.addAttribute("levels", levelsList);
		
		return "podcast";
	}
	
	@GetMapping("/adm/categories/{categorie_id}")
	public String categorie(Model model, @PathVariable Integer categorie_id) {
		model.addAttribute("page", "categories");
		model.addAttribute("default_categories", categoriesList);
		
		Categories categorie = this.categoriesDao.getOne(categorie_id);
		List<Podcasts> podcastsByCategorie = this.podcastsDao.findAllByCategories(categorie);
		
		model.addAttribute("categorie", categorie);
		model.addAttribute("podcasts", podcastsByCategorie);
		
		return "categories";
	}
		
	@PostMapping("/login")
	public String efetuarLogin(String email, String password, HttpSession session, RedirectAttributes ra) {
		// Buscar se existe um usuario com o login e senha informados
		Users user = this.usuarioDAO.findByEmail(email);
		
		if (user == null) {
			ra.addFlashAttribute("message_email", "Usuário não encontrado");
			return "redirect:/login";
		}
		
		boolean validPassword = encoder.matches(password, user.getPassword());
		
		if(!validPassword) {
			ra.addFlashAttribute("message_password", "Senha inválida");
			return "redirect:/login";
		} else {
			session.setAttribute("usuarioLogado", user);
			return "redirect:/adm/home";
		}
	}
	
	@GetMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		
		return "redirect:/login";
	}
	
	@GetMapping("/acessoNegado")
	public String acessoNegado() {
		return "redirect:/login";
	}
}

