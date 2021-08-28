package com.boompodcast;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import firebase.FirebaseController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BoomPodcastApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BoomPodcastApplication.class, args);	
	}
	
	@Bean
	ApplicationRunner applicationRunner(@Value("${firebase.adminsdk}") String sdk) throws IOException, JSONException {
		FirebaseController.initFirebaseStorageConnetion(sdk);
		
		return args -> {};
	}
	
	@Bean
	public PasswordEncoder getPasswordEnconder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder;
	}
}
