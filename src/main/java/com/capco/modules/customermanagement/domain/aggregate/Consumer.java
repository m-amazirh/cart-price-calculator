package com.capco.modules.customermanagement.domain.aggregate;

import com.capco.modules.customermanagement.domain.valueobject.ConsumerName;
import com.capco.sharedkernel.CustomerCategory;
import com.capco.sharedkernel.CustomerId;
import com.capco.sharedkernel.NotImplementedError;

public class Consumer extends Customer{
    private final ConsumerName name;
    public Consumer(CustomerId customerId, ConsumerName name) {
        super(customerId);
        this.name = name;
    }

    @Override
    public CustomerCategory getCategory() {
        throw new NotImplementedError();
    }
}
