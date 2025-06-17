package com.capco.shared.domain.valueobject;

import com.capco.shared.CustomerCategory;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ConsumerCategory implements CustomerCategory {
    public final static CustomerCategory INSTANCE = new ConsumerCategory();

    @Override
    @EqualsAndHashCode.Include
    public String getKey() {
        return "CONSUMER-CATEGORY";
    }
}
