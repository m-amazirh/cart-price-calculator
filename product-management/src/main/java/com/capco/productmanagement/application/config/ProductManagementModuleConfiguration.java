package com.capco.productmanagement.application.config;

import com.capco.productmanagement.application.mapper.AppMapper;
import com.capco.productmanagement.domain.repository.ProductRepository;
import com.capco.productmanagement.infrastructure.persistence.InMemoryProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods=false)
@ComponentScan(basePackages = "com.capco.productmanagement.application")
public class ProductManagementModuleConfiguration {
    @Bean
    public ProductRepository productRepository(){
        return new InMemoryProductRepository();
    }

    @Bean
    public AppMapper productAppMapper(){
        return new AppMapper();
    }
}
