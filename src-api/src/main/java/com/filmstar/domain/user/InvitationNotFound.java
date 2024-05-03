package com.filmstar.domain.user;

public class InvitationNotFound extends Exception {

    public InvitationNotFound(String code) {
        super("Invitation with code: " + code + " not found.");
    }

}
