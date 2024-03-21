package com.dddskeleton.apps.backoffice;

import com.dddskeleton.domain.director.Director;
import com.dddskeleton.domain.director.DirectorId;

public class SerializedDirector {

	public String id;
    public String name;
    public String surname;

    public SerializedDirector(String id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public static SerializedDirector from(Director director) {
    	return new SerializedDirector(director.id().value(), director.name().value(), director.surname().value());
    }


}
