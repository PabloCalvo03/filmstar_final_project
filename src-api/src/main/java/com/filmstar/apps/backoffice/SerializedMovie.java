package com.filmstar.apps.backoffice;

import com.filmstar.domain.movie.Movie;

public class SerializedMovie {
	
	public String id;
    public String title;
    public String overview;
    public String status;
	public SerializedDirector director;
    
    public SerializedMovie(String id, String title, String overview, String status,
						   SerializedDirector movieDirector) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.status = status;
		this.director = movieDirector;
	}

	public static SerializedMovie from(Movie movie) {
    	return new SerializedMovie(movie.id().value(), movie.title().value(), movie.overview().value(),
				movie.status().name(), SerializedDirector.from(movie.director()));
    }


}
