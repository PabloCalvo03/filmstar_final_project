package com.dddskeleton.apps.movierecords;

import com.dddskeleton.apps.backoffice.SerializedDirector;
import com.dddskeleton.domain.movie.Movie;

public class SerializedMovie {
	
	public String id;
    public String title;
    public String overview;

	public SerializedDirector director;
    
    public SerializedMovie(String id, String title, String overview, SerializedDirector movieDirector) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.director = movieDirector;
	}

	public static SerializedMovie from(Movie movie) {
    	return new SerializedMovie(movie.id().value(), movie.title().value(), movie.overview().value(),
				SerializedDirector.from(movie.director()));
    }


}
