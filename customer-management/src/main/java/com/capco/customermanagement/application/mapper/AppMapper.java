package com.capco.customermanagement.application.mapper;

import com.capco.customermanagement.application.dto.CustomerDto;
import com.capco.customermanagement.domain.aggregate.Business;
import com.capco.customermanagement.domain.aggregate.Consumer;
import com.capco.customermanagement.domain.aggregate.Customer;

public class AppMapper {
    public CustomerDto toCustomerDto(Customer customer) {
        if (customer instanceof Consumer consumer) {
            return new CustomerDto(consumer.getCustomerId().getValue().toString(), consumer.getName().getFullname(), consumer.getCategory().getKey());
        }

        if(customer instanceof Business business){
            return new CustomerDto(business.getCustomerId().getValue().toString(), business.getCompanyName(), business.getCategory().getKey());
        }

        throw new ClassCastException();
    }
}
