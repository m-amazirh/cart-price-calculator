package com.capco.modules.cartmanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;

public class InvalidCartItemQuantity extends DomainValidationException {
    public InvalidCartItemQuantity() {
        super("Invalid Cart Item quantity");
    }
}
