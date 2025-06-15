package com.capco.modules.customermanagement.aggregate;

import com.capco.shared.CustomerCategory;
import com.capco.modules.customermanagement.valueobject.CustomerId;
import lombok.NonNull;

public abstract class Customer {
    private final CustomerId customerId;

    public Customer(@NonNull CustomerId customerId){
        this.customerId = customerId;
    }

    public abstract CustomerCategory getCategory();
}
