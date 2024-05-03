package com.filmstar.apps.shared;

import com.filmstar.domain.user.Invitation;

public class SerializedInvitation {

	public String code;


    public SerializedInvitation(String code) {
		this.code = code;
	}

	public static SerializedInvitation from(Invitation invitation) {
    	return new SerializedInvitation(invitation.getCode());
    }

}
