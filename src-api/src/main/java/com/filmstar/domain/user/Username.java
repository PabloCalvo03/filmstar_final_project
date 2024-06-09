package com.filmstar.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class Username implements Serializable {

	private String value;

	public Username() {
	}

	public Username(String value) {
		this.value = value;
	}

	@JsonProperty
	public String value() {
		return value;
	}
}
