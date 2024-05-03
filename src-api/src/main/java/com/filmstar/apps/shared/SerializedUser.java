package com.filmstar.apps.shared;

import com.filmstar.apps.backoffice.SerializedDirector;
import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.user.User;

public class SerializedUser {

	public Long id;
    public String email;
    public String username;
    public String role;

    public SerializedUser(Long id, String email, String username, String role) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.role = role;
	}

	public static SerializedUser from(User user) {
    	return new SerializedUser(user.id(), user.email().value(), user.username().value(),
				user.role().name());
    }


}
