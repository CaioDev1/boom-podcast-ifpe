package boomPodcast.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boompodcast.entities.Users;

public interface UsuarioDao extends JpaRepository<Users, Integer>{
	Users findByEmail(String email);
}
