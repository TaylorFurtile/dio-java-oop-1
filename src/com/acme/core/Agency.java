package com.acme.core;

import java.util.Collection;
import java.util.HashSet;

public class Agency {
    private final String region;
    private String code;

    public Agency(String region) {
        this.region = region;
        generateCode();
    }

    public String getRegion() {
        return this.region;
    }

    public String getCode() {
        return this.code;
    }

    private static int getRandom() {
        return (int) ((Math.random() * (9 - 0)) + 0);
    }

    private void generateCode() {
        String[] codes = new String[4];

        for (int i = 0; i < 4; i++)
            codes[i] = String.valueOf(getRandom());

        this.code = String.join("", codes);
    }

    public static Collection<Agency> generate(String region, int length) {
        HashSet<Agency> set = new HashSet<>();

        for (int i = 0; i < length; i++)
            set.add(new Agency(region));

        return set;
    }

    @Override
    public String toString() {
        return this.region.toUpperCase().concat(" - ").concat(this.code);
    }
}
