package com.capco.productmanagement.infrastructure.persistence;

import com.capco.productmanagement.domain.aggregate.Product;
import com.capco.productmanagement.domain.repository.ProductRepository;
import com.capco.shared.domain.valueobject.ProductId;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryProductRepository implements ProductRepository {
    private final Map<ProductId, Product> products = new HashMap<>();
    @Override
    public Product getProductById(ProductId id) {
        return products.get(id);
    }

    @Override
    public Product save(Product product) {
        products.put(product.getProductId(), product);
        return product;
    }
}
