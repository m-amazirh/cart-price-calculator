package com.capco.shared.domain.valueobject;

import com.capco.shared.CustomerCategory;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SmallBusinessCategory implements CustomerCategory {
    public final static CustomerCategory INSTANCE = new SmallBusinessCategory();
    @Override
    @EqualsAndHashCode.Include
    public String getKey() {
        return "SMALL-BUSINESS-CATEGORY";
    }
}
