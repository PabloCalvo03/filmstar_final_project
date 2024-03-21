package com.dddskeleton.apps.movierecords;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dddskeleton.domain.movie.MovieRepository;

@RestController
@RequestMapping(value = "/api/movierecords/movies")
@Qualifier("movierecords")
public class QueryMovieListGetController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping
	public List<SerializedMovie> execute(){
		return movieRepository.findAllAvailable().stream().map(SerializedMovie::from).toList();
	}

}
