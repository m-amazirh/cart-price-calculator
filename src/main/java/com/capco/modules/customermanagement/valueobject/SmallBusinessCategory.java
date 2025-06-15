package com.capco.modules.customermanagement.valueobject;

import com.capco.shared.CustomerCategory;

public class SmallBusinessCategory implements CustomerCategory {
    @Override
    public String getKey() {
        return "SMALL-BUSINESS-CATEGORY";
    }
}
