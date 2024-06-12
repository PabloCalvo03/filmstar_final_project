package com.filmstar.apps.backoffice;

import java.io.Serializable;

/**
 * Request class for creating a director.
 */
public class CreateDirectorPostRequest implements Serializable {

    public String id;
    public String name;
    public String surname;

    /**
     * Default constructor.
     */
    public CreateDirectorPostRequest() {
    }

    /**
     * Constructor with parameters to initialize the request.
     *
     * @param id the ID of the director
     * @param name the first name of the director
     * @param surname the last name of the director
     */
    public CreateDirectorPostRequest(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
