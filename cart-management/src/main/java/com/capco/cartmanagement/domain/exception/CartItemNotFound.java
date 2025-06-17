package com.capco.cartmanagement.domain.exception;

import com.capco.shared.domain.exception.DomainValidationException;

public class CartItemNotFound extends DomainValidationException {
    public CartItemNotFound() {
        super("Cart item not found");
    }
}
