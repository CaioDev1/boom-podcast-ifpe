package com.boompodcast.acesso;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.boompodcast.podcasts.PodcastDao;
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
		
		return "home";
	}
	@GetMapping("/adm/usuario")
	public String usuario(Model model, HttpServletRequest request) {
		List<Categories> categories = this.categoriesDao.findAll();
		
		Users usuarioLogado = (Users)request.getSession().getAttribute("usuarioLogado");
		List<Podcasts> user_podcasts = this.podcastsDao.findAllByUser(usuarioLogado);
		
		model.addAttribute("page", "profile");
		model.addAttribute("categories", categories);
		model.addAttribute("user_podcasts", user_podcasts);
		model.addAttribute("user", usuarioLogado);
		
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
		
		System.out.println(reactionsIdList.toString());
				
		model.addAttribute("page", "podcast");
		model.addAttribute("podcast", podcast);
		model.addAttribute("episodes", episodes);
		model.addAttribute("user", podcastOwner);
		model.addAttribute("user_reactions", reactionsIdList);
		
		return "podcast";
	}
		
	@PostMapping("/login")
	public String efetuarLogin(String email, String password, HttpSession session, RedirectAttributes ra) {
		// Buscar se existe um usuario com o login e senha informados
		Users usuarioLogado = this.usuarioDAO.findByEmailAndPassword(email, password);
		
		if (usuarioLogado == null) {
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/login";
		} else {
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "redirect:/adm/home";
		}
	}
	
	@GetMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// trocar para um redirect para o pag de login quando o acesso for negado
	@GetMapping("/acessoNegado")
	public String acessoNegado() {
		return "redirect:/login";
	}
}

