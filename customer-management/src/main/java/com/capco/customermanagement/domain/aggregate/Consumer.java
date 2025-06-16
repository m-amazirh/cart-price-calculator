package com.capco.customermanagement.domain.aggregate;

import com.capco.customermanagement.domain.valueobject.ConsumerName;
import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.CustomerId;
import com.capco.shared.domain.exception.NotImplementedError;

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
