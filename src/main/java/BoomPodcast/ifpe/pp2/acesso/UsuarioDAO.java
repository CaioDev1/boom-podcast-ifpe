package BoomPodcast.ifpe.pp2.acesso;

import org.springframework.data.jpa.repository.JpaRepository;

// Data Access Object 
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	// select * from usuario where login = ... and senha = ...
	public Usuario findByLoginAndSenha(String login, String senha);
}
