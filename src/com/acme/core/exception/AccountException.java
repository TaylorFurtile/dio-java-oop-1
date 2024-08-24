package com.acme.core.exception;

public class AccountException extends Exception {
    private AccountException(String message) {
        super(message);
    }

    public static void ThrowInvalidAgency() throws AccountException {
        throw getInvalidAgencyException();
    }

    public static AccountException getInvalidAgencyException() {
        return new AccountException("Agency does not exists in Bank.");
    }
}
