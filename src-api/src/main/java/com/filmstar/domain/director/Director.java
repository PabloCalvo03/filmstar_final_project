package com.filmstar.domain.director;

public class Director {
	
	private DirectorId id;
	private Name name;
	private Surname surname;
	
	public Director() {
		
	}
	
	public Director(DirectorId id, Name name, Surname surname) {
		if (id == null) {
            throw new IllegalArgumentException("Director ID cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (surname == null) {
            throw new IllegalArgumentException("Surname cannot be null");
        }
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
