package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

public class Overview implements Serializable {
	
	private String value;

	private Overview() {
		
	}
	
	public Overview(String value) throws OverviewLengthNotValid, ValueError {
		ensureIsNotEmpty(value);
		ensureOverviewLengthIsValid(value);
		this.value = value;

	}
	
	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.length() == 0 || value == "") {
			throw new ValueError(getClass().getSimpleName() + " cannot be null");
		}
	}

	private void ensureOverviewLengthIsValid(String value) throws OverviewLengthNotValid {
		if (value.length() > 500) {
			throw new OverviewLengthNotValid();
		}
	}
	
	public String value() {
		return value;
	}


}
