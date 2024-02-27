package com.alura.desafio.screenmusic.screenmusic;

import com.alura.desafio.screenmusic.screenmusic.Principal.Principal;
import com.alura.desafio.screenmusic.screenmusic.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmusicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmusicApplication.class, args);
	}

	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistRepository);
		principal.exibeMenu();
	}
}
