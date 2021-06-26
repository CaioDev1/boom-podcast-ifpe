package com.boompodcast.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

// Data Access Object 
public interface UsersDAO extends JpaRepository<Users, Integer>{

	// select * from usuario where login = ... and senha = ...
	public Users findByEmailAndPassword(String email, String password);
}
