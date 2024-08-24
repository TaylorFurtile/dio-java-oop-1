package com.acme.core.abstraction;

import com.acme.core.Transaction;
import com.acme.core.exception.TransactionException;

public interface Transactional {
    Transaction startTransaction(double value) throws TransactionException;
    void withdraw(Transaction value) throws TransactionException;
    void deposit(Transaction value) throws TransactionException;
}
