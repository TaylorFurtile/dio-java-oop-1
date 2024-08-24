package com.acme.core.account;

import com.acme.core.Agency;
import com.acme.core.Bank;
import com.acme.core.Client;
import com.acme.core.Transaction;
import com.acme.core.abstraction.Transactional;
import com.acme.core.exception.AccountException;
import com.acme.core.exception.TransactionException;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Account implements Transactional {
    protected double balance;
    protected Bank bank;
    protected Agency agency;
    protected Client client;

    public Account(Bank bank, Client client) {
        this.bank = bank;
        this.client = client;
        this.balance = 0;
    }
    
    public void setAgency(Agency agency) throws AccountException {
        if (!bank.getAgencies().contains(agency))
            AccountException.ThrowInvalidAgency();

        this.agency = agency;
    }

    public void setAgency(String code) throws AccountException {
        Agency item = bank
            .getAgencies()
            .stream()
            .filter(x -> x.getCode().equals(code))
            .findFirst()
            .orElseThrow(AccountException::getInvalidAgencyException);

        this.agency = item;
    }

    public double getBalance() {
        return this.balance;
    }

    public Agency getAgency() {
        return this.agency;
    }

    public String getFormattedBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedBalance = formatter.format(this.balance);
        return formattedBalance;
    }

    @Override
    public Transaction startTransaction(double value) throws TransactionException {
        Transaction transaction = new Transaction(this);

        transaction.setValue(value);
        transaction.start();

        return transaction;
    }

    @Override
    public void withdraw(Transaction transaction) throws TransactionException {
        if (transaction.getValue() > this.balance)
            TransactionException.ThrowNotEnoughtBalance();
        
        transaction.finish();

        if (transaction.getAccount() != this)
            TransactionException.ThrowNotOwner();

        balance -= transaction.getValue();
    }

    @Override
    public void deposit(Transaction transaction) throws TransactionException {
        transaction.finish();

        if (transaction.getAccount() != this)
            TransactionException.ThrowNotOwner();

        balance += transaction.getValue();
    }
}

