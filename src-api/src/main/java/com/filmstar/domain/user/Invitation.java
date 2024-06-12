package com.filmstar.domain.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Represents an invitation to join the platform.
 */
public class Invitation implements Serializable {

    /**
     * The unique identifier for the invitation.
     */
    private Long id;

    /**
     * The code that can be used to accept the invitation.
     */
    private String code;

    /**
     * The date and time after which the invitation will expire.
     */
    private LocalDateTime expirationDate;

    /**
     * A flag indicating whether the invitation has been accepted.
     */
    private boolean used;

    /**
     * The user who sent the invitation.
     */
    private User inviter;

    /**
     * Constructs a new Invitation with the given first name, last name, and inviter.
     *
     * @param firstName the first name of the user who will receive the invitation
     * @param lastName the last name of the user who will receive the invitation
     * @param inviter the user who sent the invitation
     */
    public Invitation(String firstName, String lastName, User inviter) {
        validate(firstName, lastName);
        this.code = generateCode(firstName, lastName);
        this.expirationDate = LocalDateTime.now().plusDays(3);
        this.used = false; // By default, the invitation is not accepted
        this.inviter = inviter;
    }

    public Invitation(){

    }

    /**
     * Returns the unique identifier for the invitation.
     *
     * @return the unique identifier for the invitation
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the invitation.
     *
     * @param id the unique identifier for the invitation
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the date and time after which the invitation will expire.
     *
     * @return the date and time after which the invitation will expire
     */
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the date and time after which the invitation will expire.
     *
     * @param expirationDate the date and time after which the invitation will expire
     */
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Returns the code that can be used to accept the invitation.
     *
     * @return the code that can be used to accept the invitation
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code that can be used to accept the invitation.
     *
     * @param code the code that can be used to accept the invitation
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns a flag indicating whether the invitation has been accepted.
     *
     * @return a flag indicating whether the invitation has been accepted
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * Sets a flag indicating whether the invitation has been accepted.
     *
     * @param used a flag indicating whether the invitation has been accepted
     */
    public void setUsed(boolean used) {
        this.used = used;
    }

    /**
     * Returns the user who sent the invitation.
     *
     * @return the user who sent the invitation
     */
    public User getInviter() {
        return inviter;
    }

    /**
     * Sets the user who sent the invitation.
     *
     * @param inviter the user who sent the invitation
     */
    public void setInviter(User inviter) {
        this.inviter = inviter;
    }

    // Private method for generating the invitation code
    private String generateCode(String firstName, String lastName) {
        Random random = new Random();
        String randomDigits = String.format("%06d", random.nextInt(1000000)); // Generates 6 random digits
        return firstName.toLowerCase() + "_" + lastName.toLowerCase() + "_" + randomDigits;
    }

    // Private method for validating names
    private void validate(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name must not be empty");
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }

        if (!firstName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("First name must contain only letters");
        }

        if (!lastName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Last name must contain only letters");
        }
    }
}