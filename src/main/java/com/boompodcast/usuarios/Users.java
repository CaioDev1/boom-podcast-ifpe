package com.boompodcast.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.boompodcast.acesso.Access;
import com.boompodcast.levels.Levels;

@Entity
public class Users {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100)
	private String name;
	@Column(length = 50)
	private String email;
	@Column(length = 100)
	private String password;
	@Enumerated(EnumType.STRING)
	private Access access;
	@ManyToOne
	@JoinColumn(name = "level_id")
	private Levels level;
	
	public Levels getLevel() {
		return level;
	}
	public void setLevel(Levels level) {
		this.level = level;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNome(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Access getAccess() {
		return access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}
}
