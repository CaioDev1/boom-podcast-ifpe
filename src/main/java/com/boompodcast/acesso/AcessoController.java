package com.boompodcast.acesso;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boompodcast.usuarios.Users;
import com.boompodcast.usuarios.UsersDAO;

@Controller
public class AcessoController {

	@Autowired
	private UsersDAO usuarioDAO;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String cadastro() {
		return "register";
	}
	@GetMapping("/adm/home")
	public String home() {
		return "home";
	}
	@GetMapping("/adm/usuario")
	public String usuario() {
		return "profile";
	}
		
	@PostMapping("/login")
	public String efetuarLogin(String email, String password, HttpSession session, RedirectAttributes ra) {
		// Buscar se existe um usuario com o login e senha informados
		Users usuarioLogado = this.usuarioDAO.findByEmailAndPassword(email, password);
		if (usuarioLogado == null) {
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/";
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

