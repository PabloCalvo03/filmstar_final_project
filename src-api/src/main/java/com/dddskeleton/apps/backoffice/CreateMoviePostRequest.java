package com.dddskeleton.apps.backoffice;

import java.io.Serializable;
import java.util.UUID;

public class CreateMoviePostRequest implements Serializable{
	
	public String id;
    public String title;
    public String description;
    public String directorId;
    
    public CreateMoviePostRequest() {
    	
    }
    
    public CreateMoviePostRequest(String id, String title, String description, String directorId) {
    	this.id = id;
    	this.title = title;
    	this.description = description;
        this.directorId = directorId;
    }

}
