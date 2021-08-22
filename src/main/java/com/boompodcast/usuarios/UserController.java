package com.boompodcast.usuarios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
	
	@Autowired
	private UsersDAO userDAO;
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/cadastrar")
	public String cadastrarUsuario(Users user, RedirectAttributes ra) {
		boolean userAlreadyExists = this.userDAO.existsByEmail(user.getEmail());
		
		if(userAlreadyExists) {
			ra.addFlashAttribute("message", "Usuário já existente com esse e-mail");
			
			return "redirect:/";
		}
		
		user.setPassword(encoder.encode(user.getPassword()));

		this.userDAO.saveAndFlush(user);
		
		return "redirect:/login";
	}

}
