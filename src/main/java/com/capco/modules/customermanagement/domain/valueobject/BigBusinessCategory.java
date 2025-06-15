package com.capco.modules.customermanagement.domain.valueobject;

import com.capco.sharedkernel.CustomerCategory;

public class BigBusinessCategory implements CustomerCategory {
    @Override
    public String getKey() {
        return "BIG-BUSINESS-CATEGORY";
    }
}
