package BoomPodcast.ifpe.pp2.acesso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PerfilController {
	
	@Autowired
	private UsuarioDAO userDAO;
	
	private List<Usuario> listaUser = new ArrayList<Usuario>();
	
	@PostMapping("/salvarLogin")
	public String cadastrarCategoriaObj(Usuario user, RedirectAttributes ra) {
		// Validacoes antes de chamar o DAO
		/*if (user.getUsername().trim().isEmpty()) {
			ra.addFlashAttribute("mensagem", "nome nao pode ficar em branco");
			return "redirect:/Cadastro";
		}
		
		if (user.getEmail().trim().isEmpty()) {
			ra.addFlashAttribute("mensagem", "email nao pode ficar em branco");
			return "redirect:/Cadastro";
		}
		
		if (user.getPassword().trim().isEmpty()) {
			ra.addFlashAttribute("mensagem", "senha nao pode ficar em branco");
			return "redirect:/Cadastro";
		}
		if (user.getPassword().trim().isEmpty()) {
			ra.addFlashAttribute("mensagem", "confirmacao da senha nao pode ficar em branco");
			return "redirect:/Cadastro";
		}
		
		if (this.userDAO.existsByUsername(user.getUsername())) {
			ra.addFlashAttribute("mensagem", "email ja cadastrado");
			ra.addFlashAttribute("user", user);
			return "redirect:/Cadastro";
		}
		*/
		this.listaUser.add(user);
		this.userDAO.save(user);
		System.out.println(user);
		return "redirect:/adm/home";
	}

}
