package com.capco.customermanagement.domain.repository;

import com.capco.customermanagement.domain.aggregate.Customer;
import com.capco.shared.domain.valueobject.CustomerId;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(CustomerId customerId);

    List<Customer> getAllCustomers();
}
