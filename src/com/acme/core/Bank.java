package com.acme.core;

import com.acme.core.compators.AgencyComparator;
import java.util.Collection;
import java.util.TreeSet;

public class Bank {
    private String name;
    private TreeSet<Agency> agencies;

    public String getName() {
        return this.name;
    }

    public Collection<Agency> getAgencies() {
        return this.agencies;
    }

    public static Bank create() {
        var bank = new Bank();

        bank.name = "default";
        bank.agencies = new TreeSet<>(new AgencyComparator());

        bank.agencies.addAll(Agency.generate("SP", 8));
        bank.agencies.addAll(Agency.generate("RJ", 6));
        bank.agencies.addAll(Agency.generate("RS", 3));
        bank.agencies.addAll(Agency.generate("MG", 5));

        return bank;
    }
}