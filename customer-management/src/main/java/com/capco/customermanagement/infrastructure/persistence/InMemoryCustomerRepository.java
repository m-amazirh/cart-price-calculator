package com.capco.customermanagement.infrastructure.persistence;

import com.capco.customermanagement.domain.aggregate.Customer;
import com.capco.customermanagement.domain.repository.CustomerRepository;
import com.capco.shared.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<CustomerId, Customer> customers = new HashMap<>();

    @Override
    public Customer getCustomerById(CustomerId customerId) {
        return customers.get(customerId);
    }

    @Override
    public Customer save(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers.values().stream().toList();
    }


}
