package com.filmstar.domain.user;

public class BadInvitation extends Exception{

	public BadInvitation() {
        super("La invitacion proporcionada ya no es valida");
    }

}
