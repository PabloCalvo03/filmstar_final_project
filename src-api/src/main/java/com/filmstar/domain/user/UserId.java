package com.filmstar.domain.user;

import java.io.Serializable;

public class UserId implements Serializable{
	
	private String value;
	
	public UserId() {
    }
	
	public UserId(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
