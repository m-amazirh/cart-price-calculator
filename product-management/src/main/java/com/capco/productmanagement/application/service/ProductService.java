package com.capco.productmanagement.application.service;

import com.capco.productmanagement.application.dto.ProductDto;
import com.capco.productmanagement.application.mapper.AppMapper;
import com.capco.productmanagement.domain.aggregate.Product;
import com.capco.productmanagement.domain.repository.ProductRepository;
import com.capco.productmanagement.domain.valueobject.Pricing;
import com.capco.shared.domain.valueobject.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    @NonNull
    private final ProductRepository productRepository;
    @NonNull
    private final AppMapper appMapper;

    public ProductDto getProduct(String productId){
        Product product = productRepository.getProductById(ProductId.fromString(productId));

        return appMapper.toDto(product);
    }

    public ProductDto createProduct(String name, Double consumerPrice, Double bigBusinessPrice, Double smallBusinessPrice){
        Pricing pricing = new Pricing();
        pricing.setBasePrice(ConsumerCategory.INSTANCE, new Price(BigDecimal.valueOf(consumerPrice), MoneyAmount.SYSTEM_CURRENCY));
        pricing.setBasePrice(SmallBusinessCategory.INSTANCE, new Price(BigDecimal.valueOf(smallBusinessPrice), MoneyAmount.SYSTEM_CURRENCY));
        pricing.setBasePrice(BigBusinessCategory.INSTANCE, new Price(BigDecimal.valueOf(bigBusinessPrice), MoneyAmount.SYSTEM_CURRENCY));

        ProductId productId = new ProductId(UUID.randomUUID());
        Product product = new Product(productId, name, pricing);

        productRepository.save(product);

        return appMapper.toDto(product);
    }
}
