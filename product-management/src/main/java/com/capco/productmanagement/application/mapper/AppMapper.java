package com.capco.productmanagement.application.mapper;

import com.capco.productmanagement.application.dto.ProductDto;
import com.capco.productmanagement.domain.aggregate.Product;
import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.BigBusinessCategory;
import com.capco.shared.domain.valueobject.ConsumerCategory;
import com.capco.shared.domain.valueobject.Price;
import com.capco.shared.domain.valueobject.SmallBusinessCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMapper {
    public ProductDto toDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setProductId(product.getProductId().getValue().toString());

        Map<String, Double> pricingDto = new HashMap<>();
        for(CustomerCategory category : List.of(ConsumerCategory.INSTANCE, BigBusinessCategory.INSTANCE, SmallBusinessCategory.INSTANCE)){
            Price price = product.getPricing().getBasePrice(category);
            pricingDto.put(category.getKey(), price.getAmount().doubleValue());
        }

        productDto.setPricing(pricingDto);

        return productDto;
    }
}
