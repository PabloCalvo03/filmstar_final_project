package com.filmstar.apps.backoffice;

import com.filmstar.domain.director.Director;

public class SerializedDirector {

	public String id;
    public String name;
    public String surname;
	public String status;

    public SerializedDirector(String id, String name, String surname, String status) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.status = status;
	}

	public static SerializedDirector from(Director director) {
    	return new SerializedDirector(director.id().value(), director.name().value(), director.surname().value(), director.status().name());
    }


}
