package com.filmstar.apps.filmstar;

import java.util.List;
import java.util.stream.Collectors;

import com.filmstar.domain.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.filmstar.domain.movie.MovieRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/movies")
@Qualifier("filmstar")
public class QueryMovieListGetController {
	
	@Autowired
	private MovieRepository movieRepository;

	@GetMapping
	public PaginatedMovieResponse execute(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	){
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Movie> moviePage = movieRepository.findAllAvailable(pageRequest);

		List<SerializedMovie> serializedMovies = moviePage.getContent().stream()
				.map(SerializedMovie::from)
				.collect(Collectors.toList());

		return new PaginatedMovieResponse(
				serializedMovies,
				moviePage.getNumber(),      // current page
				moviePage.hasPrevious() ? moviePage.getNumber() - 1 : null,  // before
				moviePage.hasNext() ? moviePage.getNumber() + 1 : null      // after
		);
	}

}
