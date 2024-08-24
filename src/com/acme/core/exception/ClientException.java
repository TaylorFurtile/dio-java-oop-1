package com.acme.core.exception;

public class ClientException extends Exception {
    private ClientException(String message) {
        super(message);
    }

    public static void ThrowInvalidCpf() throws ClientException {
        throw new ClientException("Not a valid CPF.");
    }

    public static void ThrowInvalidEmail() throws ClientException {
        throw new ClientException("Not a valid Email.");
    }

    public static void ThrowInvalidName() throws ClientException {
        throw new ClientException("Not a valid Name.");
    }
}
