package com.capco.productmanagement.domain.repository;

import com.capco.productmanagement.domain.aggregate.Product;
import com.capco.shared.domain.valueobject.ProductId;

import java.util.List;

public interface ProductRepository {
    Product getProductById(ProductId id);
    Product save(Product product);

    List<Product> getAllProducts();
}
