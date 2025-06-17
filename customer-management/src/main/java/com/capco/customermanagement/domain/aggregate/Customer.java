package com.capco.customermanagement.domain.aggregate;

import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.CustomerId;
import lombok.Getter;
import lombok.NonNull;

public abstract class Customer {
    @Getter
    private final CustomerId customerId;

    public Customer(@NonNull CustomerId customerId){
        this.customerId = customerId;
    }


    public abstract CustomerCategory getCategory();
}
