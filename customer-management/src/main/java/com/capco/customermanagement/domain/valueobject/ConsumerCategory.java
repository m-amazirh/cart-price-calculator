package com.capco.customermanagement.domain.valueobject;

import com.capco.shared.CustomerCategory;

public class ConsumerCategory implements CustomerCategory {

    @Override
    public String getKey() {
        return "CONSUMER-CATEGORY";
    }
}
