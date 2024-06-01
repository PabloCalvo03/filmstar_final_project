package com.filmstar.apps.filmstar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmstar.domain.movie.MovieRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/movies")
@Qualifier("filmstar")
public class QueryMovieListGetController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping
	public List<SerializedMovie> execute(){
		return movieRepository.findAllAvailable().stream().map(SerializedMovie::from).toList();
	}

}
