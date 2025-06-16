package com.capco.productmanagement.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class ProductDto {
    String productId;
    String name;
    Map<String, Double> pricing;
}
