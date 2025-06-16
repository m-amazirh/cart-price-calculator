package com.capco.shared.domain.valueobject;

import com.capco.shared.CustomerCategory;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BigBusinessCategory implements CustomerCategory {
    public final static CustomerCategory INSTANCE = new BigBusinessCategory();
    @Override
    @EqualsAndHashCode.Include
    public String getKey() {
        return "BIG-BUSINESS-CATEGORY";
    }
}
