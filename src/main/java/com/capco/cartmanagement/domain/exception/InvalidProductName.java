package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;

public class InvalidProductName extends DomainValidationException {
    public InvalidProductName() {
        super("Invalid product name");
    }
}
