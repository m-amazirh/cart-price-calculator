package com.capco.customermanagement.application.service;

import com.capco.customermanagement.domain.aggregate.Customer;
import com.capco.customermanagement.domain.repository.CustomerRepository;
import com.capco.shared.domain.valueobject.CustomerId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerService {
    @NonNull
    private final CustomerRepository customerRepository;

    public String getCustomerCategory(String customerId){
        CustomerId id = CustomerId.fromString(customerId);
        Customer customer = customerRepository.getCustomerById(id);
        return customer.getCategory().getKey();
    }
}
