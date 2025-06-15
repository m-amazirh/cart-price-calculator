package com.capco.modules.customermanagement.domain.valueobject;

import com.capco.sharedkernel.CustomerCategory;

public class SmallBusinessCategory implements CustomerCategory {
    @Override
    public String getKey() {
        return "SMALL-BUSINESS-CATEGORY";
    }
}
