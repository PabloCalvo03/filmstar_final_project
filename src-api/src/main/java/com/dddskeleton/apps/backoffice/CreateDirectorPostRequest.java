package com.dddskeleton.apps.backoffice;

import java.io.Serializable;

public class CreateDirectorPostRequest implements Serializable{

	public String id;
    public String name;
    public String surname;

    public CreateDirectorPostRequest() {

    }

    public CreateDirectorPostRequest(String id, String name, String surname) {
    	this.id = id;
    	this.name = name;
    	this.surname = surname;
    }

}
