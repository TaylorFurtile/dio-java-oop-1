package com.acme.core.account;

import com.acme.core.Bank;
import com.acme.core.Client;
import com.acme.core.Transaction;
import com.acme.core.abstraction.Transferable;
import com.acme.core.exception.TransactionException;

public class CheckingAccount extends Account implements Transferable {
    private long limit;

    public CheckingAccount(Bank bank, Client client) {
        super(bank, client);
    }

    public long getLimit() {
        return this.limit;
    }

    public void setLimit(long value) {
        this.limit = value;
    }

    private boolean isOverLimitDeposit(Transaction transaction) {
        return this.balance + transaction.getValue() > this.limit;
    }

    @Override
    public void transferTo(Account destination, Transaction transaction) throws TransactionException {
        Transaction destinationTransaction = destination
            .startTransaction(transaction.getValue());
        
        // withdraws from this account source 
        withdraw(transaction);
        
        // to deposit on the account destination given
        destination.deposit(destinationTransaction);
    }

    @Override
    public void deposit(Transaction transaction) throws TransactionException {
        transaction.finish();
        
        if (transaction.getAccount() != this)
            TransactionException.ThrowNotOwner();
        
        if (this.limit > 0 && isOverLimitDeposit(transaction))
            TransactionException.ThrowOverLimit();
        
        balance += transaction.getValue();
    }
}