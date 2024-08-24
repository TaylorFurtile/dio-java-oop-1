package com.acme.core.exception;

public class TransactionException extends Exception {
    private TransactionException(String message) {
        super(message);
    }

    public static void ThrowNotEnoughtBalance() throws TransactionException {
        throw new TransactionException("Not enough balance to complete the transaction.");
    }
    
    public static void ThrowNotBelowZero() throws TransactionException {
        throw new TransactionException("Transaction value should be over 0.");
    }

    public static void ThrowNotOwner() throws TransactionException {
        throw new TransactionException("Transaction was not started by account.");
    }

    public static void ThrowOverLimit() throws TransactionException {
        throw new TransactionException("Transaction was not completed. You reached your limit balance and cannot deposit this much.");
    }

    public static void ThrowInvalidSituation() throws TransactionException {
        throw new TransactionException("Transaction situation could not be modified.");
    }

    public static void ThrowInvalidAction() throws TransactionException {
        throw new TransactionException("Transaction could not be modified.");
    }
}
