package boomPodcast.ifpe.pp2.dao;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioDao extends JpaRepository<User, Integer>{


	User findByEmail(String email);


}
