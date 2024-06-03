package com.filmstar.apps.filmstar;

import com.filmstar.apps.backoffice.SerializedDirector;
import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.Review;

import java.util.ArrayList;
import java.util.List;

public class SerializedMovie {
	
	public String id;
    public String title;
    public String overview;
	public String year;
	public String posterImg;
	public List<Review> reviews;

	public SerializedDirector director;
    
    public SerializedMovie(String id, String title, String overview, List<Review> reviews,
						   String year, String posterImg,
						   SerializedDirector movieDirector) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.year = year;
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
				movie.year().value(),
				movie.posterImg().value(),
				SerializedDirector.from(movie.director())
		);
	}


}
