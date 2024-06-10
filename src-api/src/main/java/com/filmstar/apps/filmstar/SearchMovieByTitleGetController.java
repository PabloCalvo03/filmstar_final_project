package com.filmstar.apps.filmstar;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.movie.Title;
import com.filmstar.domain.movie.TitleLenghtNotValid;
import com.filmstar.domain.shared.ValueError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/movies/query")
@Qualifier("filmstar")
public class SearchMovieByTitleGetController {

    Logger logger = LoggerFactory.getLogger(SearchMovieByTitleGetController.class);

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public PaginatedMovieResponse searchMoviesStartingWithTitle(
            @RequestParam(required = false) String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) throws ValueError {
        PaginatedMovieResponse response = new PaginatedMovieResponse();

        if (query == null || query.isEmpty()) {
            // If query is empty or null, return all available movies paginated
            Page<Movie> moviePage = movieRepository.findAllAvailable(PageRequest.of(page, size));
            response.setMovies(getPagedSerializedMovies(moviePage));
        } else {
            logger.info("Buscando películas con título que comienza con: " + query);
            try {
                // Obtener la lista de películas desde el repositorio paginada
                Page<Movie> moviePage = movieRepository.findMoviesByTitleContainingAndAvailable(new Title(query), PageRequest.of(page, size));
                response.setMovies(getPagedSerializedMovies(moviePage));
            } catch (TitleLenghtNotValid e) {
                throw new RuntimeException(e);
            }
        }

        response.setCurrentPage(page);
        response.setBefore(Math.max(0, page - 1));
        response.setAfter(page + 1);

        return response;
    }

    private List<SerializedMovie> getPagedSerializedMovies(Page<Movie> moviePage) {
        // Convertir cada Movie a SerializedMovie
        return moviePage.getContent().stream()
                .map(SerializedMovie::from)
                .collect(Collectors.toList());
    }
}
