package com.filmstar.domain.user;

import java.io.Serializable;

public final class Password implements Serializable {

	private String value;

	public Password() {
	}
	
	public Password(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
