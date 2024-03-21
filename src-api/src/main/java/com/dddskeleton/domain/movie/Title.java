package com.dddskeleton.domain.movie;

import java.io.Serializable;

public class Title implements Serializable {
	
private String value;

	public Title() {
	}
	
	public Title(String value) throws TitleLenghtNotValid {
		ensureTitleLengthIsValid(value);
		this.value = value;
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
