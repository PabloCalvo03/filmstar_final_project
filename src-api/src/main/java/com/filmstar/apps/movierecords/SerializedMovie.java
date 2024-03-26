package com.filmstar.apps.movierecords;

import com.filmstar.apps.backoffice.SerializedDirector;
import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.Review;
import com.filmstar.domain.movie.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SerializedMovie {
	
	public String id;
    public String title;
    public String overview;

	public String posterImg;
	public List<Review> reviews;

	public SerializedDirector director;
    
    public SerializedMovie(String id, String title, String overview, List<Review> reviews, String posterImg,
						   SerializedDirector movieDirector) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.posterImg = posterImg;
		this.reviews = reviews;
		this.director = movieDirector;
	}

	public static SerializedMovie from(Movie movie) {
		List<Review> reviews = movie.reviews() != null ? movie.reviews() : new ArrayList<>();
		return new SerializedMovie(
				movie.id().value(),
				movie.title().value(),
				movie.overview().value(),
				reviews,
				movie.posterImg().value(),
				SerializedDirector.from(movie.director())
		);
	}


}
