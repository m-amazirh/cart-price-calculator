package com.capco.modules.customermanagement.aggregate;

import com.capco.modules.customermanagement.valueobject.ConsumerName;
import com.capco.shared.CustomerCategory;
import com.capco.modules.customermanagement.valueobject.CustomerId;
import com.capco.shared.NotImplementedError;

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
