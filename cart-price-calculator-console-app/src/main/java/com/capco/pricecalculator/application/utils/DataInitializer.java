package com.capco.pricecalculator.application.utils;

import com.capco.customermanagement.application.service.CustomerService;
import com.capco.productmanagement.application.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final ProductService productService;
    private final CustomerService customerService;
    @PostConstruct
    public void initializeData() {
        customerService.createConsumer("Jean","Dupont");
        customerService.createBusiness("Dell", "351528229", 1000d);
        customerService.createBusiness("Microsoft", "327733184", 100_000_000d);

        productService.createProduct("Laptop",
                        1200d,
                        900d,
                        1000d);

        productService.createProduct("High End Phone",
                                1500d,
                                1000d,
                                1150d);

        productService.createProduct("Mid End Phone",
                                800d,
                                550d,
                                600d);
    }
}
