package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

public class Title implements Serializable {
	
	private String value;

	public Title() {
	}
	
	public Title(String value) throws TitleLenghtNotValid, ValueError {
		ensureIsNotEmpty(value);
		ensureTitleLengthIsValid(value);
		this.value = value;
	}
	
	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null ||value.length() == 0 || value == "") {
			throw new ValueError(getClass().getSimpleName() + " cannot be null");
		}
	}
	
	private void ensureTitleLengthIsValid(String value) throws TitleLenghtNotValid {
		if (value.length() > 20) {
			throw new TitleLenghtNotValid();
		}
	}
	
	public String value() {
		return value;
	}

}
