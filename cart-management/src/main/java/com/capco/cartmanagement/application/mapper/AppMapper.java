package com.capco.cartmanagement.application.mapper;

import com.capco.cartmanagement.application.dto.CartItemDto;
import com.capco.cartmanagement.application.dto.CartSummaryDto;
import com.capco.cartmanagement.domain.aggregate.Cart;
import com.capco.cartmanagement.domain.aggregate.CartItem;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppMapper {
    public CartItemDto toCartItemDto(CartItem cartItem, String productName, Double totalPrice) {
        return new CartItemDto(
                cartItem.getProductId().getValue().toString(),
                productName,
                cartItem.getQuantity(),
                cartItem.getUnitPrice().getAmount().doubleValue(),
                totalPrice

        );
    }

    public CartSummaryDto toCartSummaryDto(Cart cart, Map<String, String> productNames, Map<String, Double> totalPricePerItem) {
        List<CartItemDto> itemDtos = cart.getCartItems().values().stream()
                .map(item -> toCartItemDto(item, productNames.get(item.getProductId().getValue().toString()), totalPricePerItem.get(item.getProductId().getValue().toString())))
                .collect(Collectors.toList());

        return new CartSummaryDto(cart.getCartId().getValue().toString(), cart.calculateTotalPrice().getAmount().doubleValue(), itemDtos);
    }
}
