package com.capco.cartmanagement.infrastructure.persistence;

import com.capco.cartmanagement.domain.aggregate.Cart;
import com.capco.cartmanagement.domain.repository.CartRepository;
import com.capco.cartmanagement.domain.valueobject.CartId;
import com.capco.shared.domain.valueobject.ProductId;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCartRepository implements CartRepository {
    private final Map<CartId, Cart> repository = new HashMap<>();
    @Override
    public Cart getCartById(@NonNull CartId id) {
        return repository.get(id);
    }



    @Override
    public Cart save(@NonNull Cart cart) {
        repository.put(cart.getCartId(), cart);
        return cart;
    }
}
