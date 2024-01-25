package com.cirilgroup.aventurier;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AventurierApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AventurierApplication.class, args);
		Game.playGame();
	}
}
