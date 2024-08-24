package com.acme.core.account;

import com.acme.core.Bank;
import com.acme.core.Client;

public class SavingAccount extends Account {
    public SavingAccount(Bank bank, Client client) {
        super(bank, client);
    }
}
