package com.acme.core;

import com.acme.core.exception.ClientException;

public class Client {
    private final String cpf;
    private String name;
    private String email;

    public Client(String cpf) throws ClientException {
        if (isValidCpf(cpf) == false)
            ClientException.ThrowInvalidCpf();

        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) throws ClientException {
        if (isValidEmail(email) == false)
            ClientException.ThrowInvalidEmail();

        this.email = email;
    }

    public void setName(String name) throws ClientException {
        if (name.isBlank())
            ClientException.ThrowInvalidName();

        this.name = name.trim().toUpperCase();
    }

    private boolean isValidCpf(String cpf) {
        return cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w\\-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
