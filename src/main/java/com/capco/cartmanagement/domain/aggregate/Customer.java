package com.capco.cartmanagement.domain.aggregate;

import com.capco.cartmanagement.domain.valueobject.CustomerCategory;
import com.capco.cartmanagement.domain.valueobject.CustomerId;
import lombok.NonNull;

public abstract class Customer {
    private final CustomerId customerId;

    public Customer(@NonNull CustomerId customerId){
        this.customerId = customerId;
    }

    public abstract CustomerCategory getCategory();
}
