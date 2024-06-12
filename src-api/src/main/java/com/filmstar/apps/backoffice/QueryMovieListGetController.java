package com.filmstar.apps.backoffice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieRepository;

/**
 * REST controller for querying a list of movies.
 */
@RestController("backoffice")
@RequestMapping(value = "/api/backoffice/movies")
@Qualifier("backoffice")
@CrossOrigin("*")
public class QueryMovieListGetController {

	@Autowired
	private MovieRepository movieRepository;

	/**
	 * Retrieves a paginated list of movies.
	 *
	 * @param page the page number (default is 0)
	 * @param size the number of items per page (default is 10)
	 * @return a PaginatedMovieResponse containing the list of serialized movies,
	 *         the current page number, the page number of the previous page (if exists),
	 *         and the page number of the next page (if exists)
	 */
	@GetMapping
	public PaginatedMovieResponse execute(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Movie> moviePage = movieRepository.findAll(pageRequest);

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
