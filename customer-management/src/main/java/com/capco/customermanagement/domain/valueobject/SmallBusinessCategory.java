package com.capco.customermanagement.domain.valueobject;

import com.capco.shared.CustomerCategory;

public class SmallBusinessCategory implements CustomerCategory {
    @Override
    public String getKey() {
        return "SMALL-BUSINESS-CATEGORY";
    }
}
