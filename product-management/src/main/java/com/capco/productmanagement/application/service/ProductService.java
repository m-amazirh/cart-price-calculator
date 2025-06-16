package com.capco.productmanagement.application.service;

import com.capco.productmanagement.application.dto.ProductDto;
import com.capco.productmanagement.application.mapper.AppMapper;
import com.capco.productmanagement.domain.aggregate.Product;
import com.capco.productmanagement.domain.repository.ProductRepository;
import com.capco.shared.domain.valueobject.ProductId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
}
