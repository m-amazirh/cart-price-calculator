package com.capco.cartmanagement.domain.repository;

import com.capco.cartmanagement.domain.aggregate.Cart;
import com.capco.cartmanagement.domain.valueobject.CartId;

public interface CartRepository {
    Cart getCartById(CartId id);
    Cart save(Cart cart);
}
