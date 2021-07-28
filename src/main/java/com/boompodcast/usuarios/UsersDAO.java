package com.boompodcast.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer>{
	
	public Users findByEmailAndPassword(String email, String password);
}
