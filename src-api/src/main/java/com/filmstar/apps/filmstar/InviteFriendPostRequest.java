package com.filmstar.apps.filmstar;

/**
 * A request object for inviting a friend in the Filmstar application.
 */
public class InviteFriendPostRequest {

    public String firstname;

    public String lastname;

    /**
     * Constructs an empty InviteFriendPostRequest object.
     */
    public InviteFriendPostRequest() {

    }

    /**
     * Constructs an InviteFriendPostRequest object with the provided parameters.
     *
     * @param firstname the first name of the friend to invite
     * @param lastname  the last name of the friend to invite
     */
    public InviteFriendPostRequest(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
