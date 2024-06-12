package com.filmstar.apps.backoffice;

import com.filmstar.domain.director.Director;

/**
 * A class for serializing Director objects into JSON format.
 */
public class SerializedDirector {

	public String id;
	public String name;
	public String surname;
	public String status;

	/**
	 * Constructs a SerializedDirector object with the provided parameters.
	 *
	 * @param id      the ID of the director
	 * @param name    the name of the director
	 * @param surname the surname of the director
	 * @param status  the status of the director
	 */
	public SerializedDirector(String id, String name, String surname, String status) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.status = status;
	}

	/**
	 * Creates a SerializedDirector object from a Director object.
	 *
	 * @param director the Director object to serialize
	 * @return a SerializedDirector object
	 */
	public static SerializedDirector from(Director director) {
		return new SerializedDirector(
				director.id().value(),
				director.name().value(),
				director.surname().value(),
				director.status().name()
		);
	}
}
