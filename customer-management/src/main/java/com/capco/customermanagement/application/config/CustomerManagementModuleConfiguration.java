package com.capco.customermanagement.application.config;

import com.capco.customermanagement.application.mapper.AppMapper;
import com.capco.customermanagement.domain.repository.CustomerRepository;
import com.capco.customermanagement.infrastructure.persistence.InMemoryCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration(proxyBeanMethods=false)
@ComponentScan(basePackages = "com.capco.customermanagement.application")
public class CustomerManagementModuleConfiguration {
    @Bean
    public CustomerRepository customerRepository(){
        return new InMemoryCustomerRepository();
    }

    @Bean
    public AppMapper customerAppMapper(){
        return new AppMapper();
    }
}