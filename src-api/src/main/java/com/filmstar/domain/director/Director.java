package com.filmstar.domain.director;

import com.filmstar.domain.shared.Status;

public class Director {
	
	private DirectorId id;
	private Name name;
	private Surname surname;
	private Status status;
	
	public Director() {
		
	}
	
	public Director(DirectorId id, Name name, Surname surname) {
		this.id = id;
		this.name = name; 
		this.surname = surname;
		this.status = Status.AVAILABLE;
	}

	public DirectorId id() {
		return id;
	}

	public Name name() {
		return name;
	}

	public Surname surname() {
		return surname;
	}

	public Status status(){
		return status;
	}
}
