package com.capco.modules.customermanagement.valueobject;

import com.capco.shared.CustomerCategory;

public class BigBusinessCategory implements CustomerCategory {
    @Override
    public String getKey() {
        return "BIG-BUSINESS-CATEGORY";
    }
}
