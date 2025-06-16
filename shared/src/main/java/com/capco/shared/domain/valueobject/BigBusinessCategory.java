package com.capco.shared.domain.valueobject;

import com.capco.shared.CustomerCategory;

public class BigBusinessCategory implements CustomerCategory {
    public final static CustomerCategory INSTANCE = new BigBusinessCategory();
    @Override
    public String getKey() {
        return "BIG-BUSINESS-CATEGORY";
    }
}
