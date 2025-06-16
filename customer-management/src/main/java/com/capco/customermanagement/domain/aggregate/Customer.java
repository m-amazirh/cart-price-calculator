package com.capco.customermanagement.domain.aggregate;

import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.CustomerId;
import lombok.NonNull;

public abstract class Customer {
    private final CustomerId customerId;

    public Customer(@NonNull CustomerId customerId){
        this.customerId = customerId;
    }

    public CustomerId getCustomerId(){
        return customerId;
    }

    public abstract CustomerCategory getCategory();
}
