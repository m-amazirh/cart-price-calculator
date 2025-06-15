package com.capco.modules.cartmanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;
import lombok.NonNull;

public class CartItemNotFound extends DomainValidationException {
    public CartItemNotFound() {
        super("Cart item not found");
    }
}
