package com.capco.modules.customermanagement.domain.valueobject;

import com.capco.sharedkernel.CustomerCategory;

public class ConsumerCategory implements CustomerCategory {

    @Override
    public String getKey() {
        return "CONSUMER-CATEGORY";
    }
}
