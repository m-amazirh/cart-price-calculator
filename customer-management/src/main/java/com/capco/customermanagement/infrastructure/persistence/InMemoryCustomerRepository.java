package com.capco.customermanagement.infrastructure.persistence;

import com.capco.customermanagement.domain.aggregate.Business;
import com.capco.customermanagement.domain.aggregate.Consumer;
import com.capco.customermanagement.domain.aggregate.Customer;
import com.capco.customermanagement.domain.repository.CustomerRepository;
import com.capco.customermanagement.domain.valueobject.AnnualTurnover;
import com.capco.customermanagement.domain.valueobject.ConsumerName;
import com.capco.customermanagement.domain.valueobject.SirenNumber;
import com.capco.shared.domain.valueobject.CustomerId;
import com.capco.shared.domain.valueobject.MoneyAmount;
import com.capco.shared.domain.valueobject.SmallBusinessCategory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<CustomerId, Customer> customers = new HashMap<>();

    public InMemoryCustomerRepository() {
        Customer consumer = new Consumer(new CustomerId(UUID.randomUUID()), new ConsumerName("Jean", "Dupont"));
        Customer smallBusiness = new Business(new CustomerId(UUID.randomUUID()),
                "Microsft",
                new AnnualTurnover(BigDecimal.valueOf(2000), MoneyAmount.SYSTEM_CURRENCY),
                new SirenNumber("327733184"));

        Customer bigBusiness = new Business(new CustomerId(UUID.randomUUID()),
                "Dell",
                new AnnualTurnover(BigDecimal.valueOf(20_000_000), MoneyAmount.SYSTEM_CURRENCY),
                new SirenNumber("351528229"));

        customers.put(consumer.getCustomerId(), consumer);
        customers.put(smallBusiness.getCustomerId(), smallBusiness);
        customers.put(bigBusiness.getCustomerId(), bigBusiness);
    }

    @Override
    public Customer getCustomerById(CustomerId customerId) {
        return customers.get(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers.values().stream().toList();
    }


}
