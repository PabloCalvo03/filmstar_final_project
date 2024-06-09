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
    public List<SerializedMovie> searchMoviesStartingWithTitle(@RequestParam String query) throws ValueError {
    	if(query == "" || query == null || query.length() == 0) {
    		return movieRepository.findAllAvailable().stream().map(SerializedMovie::from)
                    .collect(Collectors.toList());
    	}
        try {
            logger.info("Buscando películas con título que comienza con: " + query);

            // Obtener la lista de películas desde el repositorio
            List<Movie> movies = movieRepository.findMoviesByTitleContainingAndAvailable(new Title(query));

            // Convertir cada Movie a SerializedMovie
            List<SerializedMovie> serializedMovies = movies.stream()
                    .map(SerializedMovie::from)
                    .collect(Collectors.toList());

            return serializedMovies;
        } catch (TitleLenghtNotValid e) {
            throw new RuntimeException(e);
        }
    }
}
