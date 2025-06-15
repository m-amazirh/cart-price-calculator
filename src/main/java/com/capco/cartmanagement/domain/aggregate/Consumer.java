package com.capco.cartmanagement.domain.aggregate;

import com.capco.cartmanagement.domain.valueobject.ConsumerName;
import com.capco.cartmanagement.domain.valueobject.CustomerCategory;
import com.capco.cartmanagement.domain.valueobject.CustomerId;
import com.capco.cartmanagement.shared.utils.NotImplementedError;

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
