package com.filmstar.apps.shared;

import com.filmstar.domain.user.Invitation;

/**
 * A class representing a serialized invitation in the Filmstar application.
 */
public class SerializedInvitation {

	public String code;

	/**
	 * Constructs a SerializedInvitation object with the provided invitation code.
	 *
	 * @param code the invitation code
	 */
	public SerializedInvitation(String code) {
		this.code = code;
	}

	/**
	 * Converts an Invitation object to a SerializedInvitation object.
	 *
	 * @param invitation the Invitation object to convert
	 * @return the corresponding SerializedInvitation object
	 */
	public static SerializedInvitation from(Invitation invitation) {
		return new SerializedInvitation(invitation.getCode());
	}

}
