package com.dddskeleton.domain.director;

public class Director {
	
	private DirectorId id;
	private Name name;
	private Surname surname;
	
	public Director() {
		
	}
	
	public Director(DirectorId id, Name name, Surname surname) {
		this.id = id;
		this.name = name; 
		this.surname = surname;
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
}
