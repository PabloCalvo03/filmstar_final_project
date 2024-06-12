package com.filmstar.domain.director;

import com.filmstar.domain.shared.Status;

/**
 * Represents a director entity in the film industry.
 */
public class Director {

	private DirectorId id;         // The unique identifier of the director.
	private Name name;             // The name of the director.
	private Surname surname;       // The surname of the director.
	private Status status;         // The status of the director.

	/**
	 * Default constructor.
	 */
	public Director() {

	}

	/**
	 * Parameterized constructor to initialize a Director with specified values.
	 *
	 * @param id      The unique identifier of the director.
	 * @param name    The name of the director.
	 * @param surname The surname of the director.
	 */
	public Director(DirectorId id, Name name, Surname surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.status = Status.AVAILABLE;  // Default status is set to AVAILABLE.
	}

	/**
	 * Retrieves the unique identifier of the director.
	 *
	 * @return The director's unique identifier.
	 */
	public DirectorId id() {
		return id;
	}

	/**
	 * Retrieves the name of the director.
	 *
	 * @return The director's name.
	 */
	public Name name() {
		return name;
	}

	/**
	 * Retrieves the surname of the director.
	 *
	 * @return The director's surname.
	 */
	public Surname surname() {
		return surname;
	}

	/**
	 * Retrieves the status of the director.
	 *
	 * @return The director's status.
	 */
	public Status status(){
		return status;
	}
}

