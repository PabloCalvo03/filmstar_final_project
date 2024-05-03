package com.filmstar.apps.filmstar;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.movie.Title;
import com.filmstar.domain.movie.TitleLenghtNotValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/movierecords/movies/query")
@Qualifier("movierecords")
public class SearchMovieByTitleGetController {

    Logger logger = LoggerFactory.getLogger(SearchMovieByTitleGetController.class);

    // Inyecta el servicio de películas para realizar la búsqueda
    @Autowired
    private MovieRepository movieRepository;

    // Maneja las solicitudes GET para buscar películas por título
    @GetMapping
    public List<SerializedMovie> searchMoviesStartingWithTitle(@RequestParam String query) {
        try {
            logger.info("Buscando películas con título que comienza con: " + query);

            // Obtener la lista de películas desde el repositorio
            List<Movie> movies = movieRepository.findMoviesByTitleStartingWith(new Title(query));

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
