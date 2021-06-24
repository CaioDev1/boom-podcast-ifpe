package com.boompodcast.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	@Id
	private String nomeRole;

	@ManyToMany(mappedBy = "roles")
    private List<Users> usuarios;
	
	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}
	
	public List<Users> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Users> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomeRole;
	}
}
