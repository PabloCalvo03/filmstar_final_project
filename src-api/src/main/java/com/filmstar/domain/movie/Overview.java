package com.filmstar.domain.movie;

import java.io.Serializable;

public class Overview implements Serializable {
	
	private String value;

	private Overview() {
		
	}
	
	public Overview(String value) throws OverviewLengthNotValid {
		ensureOverviewLengthIsValid(value);
		this.value = value;

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
