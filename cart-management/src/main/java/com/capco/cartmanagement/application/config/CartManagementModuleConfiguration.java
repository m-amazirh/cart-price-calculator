package com.capco.cartmanagement.application.config;

import com.capco.cartmanagement.application.mapper.AppMapper;
import com.capco.cartmanagement.domain.repository.CartRepository;
import com.capco.cartmanagement.infrastructure.persistence.InMemoryCartRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods=false)
@ComponentScan(basePackages = "com.capco.cartmanagement.application")
public class CartManagementModuleConfiguration {
    @Bean
    public CartRepository cartRepository(){
        return new InMemoryCartRepository();
    }

    @Bean
    public AppMapper cartAppMapper(){
        return new AppMapper();
    }
}
