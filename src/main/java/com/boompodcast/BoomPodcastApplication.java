package com.boompodcast;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import firebase.FirebaseController;

@SpringBootApplication
public class BoomPodcastApplication {

	public static void main(String[] args) throws IOException {
	
		SpringApplication.run(BoomPodcastApplication.class, args);
		
		FirebaseController.initFirebaseStorageConnetion();
	}

}
