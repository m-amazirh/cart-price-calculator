package com.capco.productmanagement.domain.exception;

import com.capco.shared.DomainValidationException;

public class InvalidProductName extends DomainValidationException {
    public InvalidProductName() {
        super("Invalid product name");
    }
}
