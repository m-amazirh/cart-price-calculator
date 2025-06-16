package com.capco.shared.domain.valueobject;

import com.capco.shared.CustomerCategory;

public class SmallBusinessCategory implements CustomerCategory {
    public final static CustomerCategory INSTANCE = new SmallBusinessCategory();
    @Override
    public String getKey() {
        return "SMALL-BUSINESS-CATEGORY";
    }
}
