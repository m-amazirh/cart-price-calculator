package com.capco.modules.customermanagement.domain.aggregate;

import com.capco.sharedkernel.CustomerCategory;
import com.capco.sharedkernel.CustomerId;
import lombok.NonNull;

public abstract class Customer {
    private final CustomerId customerId;

    public Customer(@NonNull CustomerId customerId){
        this.customerId = customerId;
    }

    public abstract CustomerCategory getCategory();
}
