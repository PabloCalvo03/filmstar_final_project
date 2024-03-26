package com.filmstar.domain.user;

import java.io.Serializable;

public final class Username implements Serializable {

	private String value;

	public Username() {
	}
	
	public Username(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
