package com.filmstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class for the Filmstar application.
 */
@SpringBootApplication
public class FilmstarApplication {

	/**
	 * The main method to start the application.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FilmstarApplication.class, args);
	}

}