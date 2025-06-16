package com.capco.cartmanagement.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartSummaryDto {
    private String cartId;
    private String customerId;
    private Double totalPrice;
    private List<CartItemDto> items;
}
