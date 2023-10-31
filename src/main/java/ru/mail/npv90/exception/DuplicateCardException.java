package ru.mail.npv90.exception;

public class DuplicateCardException extends RuntimeException {
    public DuplicateCardException(String message) {
        super(message);
    }
}
