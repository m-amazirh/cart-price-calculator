package com.capco.cartmanagement.domain.exception;

import com.capco.shared.domain.exception.DomainValidationException;

public class InvalidCartItemQuantity extends DomainValidationException {
    public InvalidCartItemQuantity() {
        super("Invalid Cart Item quantity");
    }
}
