package com.filmstar.domain.movie;

public class Review {
	
	private Long id;
	
	private String comment;
	
	public Review() {
		
	}

	public Review(String comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
}
