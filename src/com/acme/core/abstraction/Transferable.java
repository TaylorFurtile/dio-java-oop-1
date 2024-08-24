package com.acme.core.abstraction;

import com.acme.core.Transaction;
import com.acme.core.account.Account;
import com.acme.core.exception.TransactionException;

public interface Transferable {
    void transferTo(Account destination, Transaction transaction) throws TransactionException;
}
