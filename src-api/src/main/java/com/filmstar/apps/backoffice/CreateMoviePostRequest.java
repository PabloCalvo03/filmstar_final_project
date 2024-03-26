package com.filmstar.apps.backoffice;

import java.io.Serializable;

public class CreateMoviePostRequest implements Serializable{
	
	public String id;
    public String title;
    public String description;

    public String posterImg;
    public String directorId;
    
    public CreateMoviePostRequest() {
    	
    }
    
    public CreateMoviePostRequest(String id, String title, String description, String posterImg, String directorId) {
    	this.id = id;
    	this.title = title;
    	this.description = description;
        this.posterImg = posterImg;
        this.directorId = directorId;
    }

}
