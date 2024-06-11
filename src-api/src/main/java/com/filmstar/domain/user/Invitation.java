package com.filmstar.domain.user;

import java.time.LocalDateTime;
import java.util.Random;

public class Invitation {

    private Long id;
    private String code;
    private LocalDateTime expirationDate;
    private boolean used;
    private User inviter; // Usuario que hizo la invitación

    public Invitation() {
    }

    public Invitation(String firstName, String lastName, User inviter) {
        validate(firstName, lastName);
        this.code = generateCode(firstName, lastName);
        this.expirationDate = LocalDateTime.now().plusDays(3);
        this.used = false; // Por defecto, la invitación no está aceptada
        this.inviter = inviter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public User getInviter() {
        return inviter;
    }

    public void setInviter(User inviter) {
        this.inviter = inviter;
    }

    // Método privado para generar el código de invitación
    private String generateCode(String firstName, String lastName) {
        Random random = new Random();
        String randomDigits = String.format("%06d", random.nextInt(1000000)); // Genera 6 dígitos aleatorios
        return firstName.toLowerCase() + "_" + lastName.toLowerCase() + "_" + randomDigits;
    }

    // Método privado para validar nombres
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
