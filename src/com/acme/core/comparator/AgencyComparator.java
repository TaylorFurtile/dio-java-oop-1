package com.acme.core.comparator;

import com.acme.core.Agency;
import java.util.Comparator;

public class AgencyComparator implements Comparator<Agency> {

    @Override
    public int compare(Agency arg0, Agency arg1) {
        return 
            arg0.getRegion().compareTo(arg1.getRegion()) +
            arg0.getCode().compareTo(arg1.getCode());
    }
}