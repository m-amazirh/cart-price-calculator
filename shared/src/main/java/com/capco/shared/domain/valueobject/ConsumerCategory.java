package com.capco.shared.domain.valueobject;

import com.capco.shared.CustomerCategory;

public class ConsumerCategory implements CustomerCategory {
    public final static CustomerCategory INSTANCE = new ConsumerCategory();

    @Override
    public String getKey() {
        return "CONSUMER-CATEGORY";
    }
}
