package boomPodcast.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boompodcast.entities.Users;

import boomPodcast.ifpe.pp2.dao.UsuarioDao;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping("/")
	public String chamaCadastro() {
		return "cadastro";
	}
	@GetMapping("/login")
	public String chamaLogin() {
		return "login";
	}
	@PostMapping("/CadastraUsuario")
	public String cadastrarUsuario(Users usuario) {
		this.usuarioDao.save(usuario);	
		return "home";
	}
}
