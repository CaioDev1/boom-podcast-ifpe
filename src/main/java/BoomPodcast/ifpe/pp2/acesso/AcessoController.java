package BoomPodcast.ifpe.pp2.acesso;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AcessoController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/cadastro")
	public String cadastrro() {
		return "cadastro";
	}
	@GetMapping("/adm/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/adm/usuario")
	public String usuario() {
		return "usuario";
	}
		
	@PostMapping("/login")
	public String efetuarLogin(String login, String senha, HttpSession session, RedirectAttributes ra) {
		// Buscar se existe um usuario com o login e senha informados
		Usuario usuarioLogado = this.usuarioDAO.findByLoginAndSenha(login, senha);
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
	
	@GetMapping("/acessoNegado")
	public String acessoNegado() {
		return "acesso_negado";
	}
}

