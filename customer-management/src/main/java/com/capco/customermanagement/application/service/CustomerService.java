package com.capco.customermanagement.application.service;

import com.capco.customermanagement.application.dto.CustomerDto;
import com.capco.customermanagement.application.mapper.AppMapper;
import com.capco.customermanagement.domain.aggregate.Business;
import com.capco.customermanagement.domain.aggregate.Consumer;
import com.capco.customermanagement.domain.aggregate.Customer;
import com.capco.customermanagement.domain.repository.CustomerRepository;
import com.capco.customermanagement.domain.valueobject.AnnualTurnover;
import com.capco.customermanagement.domain.valueobject.ConsumerName;
import com.capco.customermanagement.domain.valueobject.SirenNumber;
import com.capco.shared.domain.valueobject.CustomerId;
import com.capco.shared.domain.valueobject.MoneyAmount;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerService {
    @NonNull
    private final CustomerRepository customerRepository;
    @NonNull
    private final AppMapper appMapper;

    public CustomerDto getCustomer(String customerId){
        CustomerId id = CustomerId.fromString(customerId);
        Customer customer = customerRepository.getCustomerById(id);
        return appMapper.toCustomerDto(customer);
    }

    public String getCustomerCategory(String customerId){
        CustomerId id = CustomerId.fromString(customerId);
        Customer customer = customerRepository.getCustomerById(id);
        return customer.getCategory().getKey();
    }

    public String createConsumer(String firstName, String lastName){
        CustomerId customerId = new CustomerId(UUID.randomUUID());
        Consumer consumer = new Consumer(customerId, new ConsumerName(firstName, lastName));

        customerRepository.save(consumer);
        return customerId.getValue().toString();
    }

    public String createBusiness(String companyName, String siren, Double annualTurnover){
        CustomerId customerId = new CustomerId(UUID.randomUUID());
        Business business = new Business(customerId, companyName, new SirenNumber(siren),new AnnualTurnover(BigDecimal.valueOf(annualTurnover),MoneyAmount.SYSTEM_CURRENCY));

        customerRepository.save(business);
        return customerId.getValue().toString();
    }
}
