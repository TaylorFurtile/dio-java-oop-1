package com.acme.core;

import com.acme.core.account.Account;
import com.acme.core.enums.TransactionSituationEnum;
import com.acme.core.exception.TransactionException;

public class Transaction  {
    private final Account source;
    private TransactionSituationEnum situation;
    private double value;

    public Transaction(Account source) {
        this.source = source;
        this.value = 0;
        this.situation = TransactionSituationEnum.NOT_READY;
    }

    public Account getAccount() {
        return this.source;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) throws TransactionException {
        if (this.situation == TransactionSituationEnum.STARTED || this.situation == TransactionSituationEnum.FINISHED)
            TransactionException.ThrowInvalidAction();

        if (value < 0)
            TransactionException.ThrowNotBelowZero();

        // truncate value to 2 fraction digits like currency values
        this.value = Math.floor(value * 100) / 100;
    }

    public void start() throws TransactionException {
        if (canSituationChangeTo(TransactionSituationEnum.STARTED) == false)
            TransactionException.ThrowInvalidSituation();

        this.situation = TransactionSituationEnum.STARTED;
    }

    public void finish() throws TransactionException {
        if (canSituationChangeTo(TransactionSituationEnum.FINISHED) == false)
            TransactionException.ThrowInvalidSituation();

        this.situation = TransactionSituationEnum.FINISHED;
    }

    private boolean canSituationChangeTo(TransactionSituationEnum option) {
        return this.situation.compareTo(option) < 0;
    }
}