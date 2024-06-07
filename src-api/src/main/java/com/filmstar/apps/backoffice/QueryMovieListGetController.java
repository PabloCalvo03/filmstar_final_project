package com.filmstar.apps.backoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmstar.domain.movie.MovieRepository;

@RestController("backoffice")
@RequestMapping(value = "/api/backoffice/movies")
@Qualifier("backoffice")
@CrossOrigin("*")
public class QueryMovieListGetController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping
	public List<SerializedMovie> execute(){
		return movieRepository.findAll().stream().map(movie -> SerializedMovie.from(movie)).toList();
	}

}
