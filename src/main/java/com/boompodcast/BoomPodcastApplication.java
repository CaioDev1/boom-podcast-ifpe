package com.boompodcast;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import firebase.FirebaseController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BoomPodcastApplication {

	public static void main(String[] args) throws IOException {
	
		SpringApplication.run(BoomPodcastApplication.class, args);
		
		FirebaseController.initFirebaseStorageConnetion();
	}
	
	@Bean
	public PasswordEncoder getPasswordEnconder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder;
	}
}
