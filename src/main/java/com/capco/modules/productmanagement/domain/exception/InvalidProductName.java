package com.capco.modules.productmanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;

public class InvalidProductName extends DomainValidationException {
    public InvalidProductName() {
        super("Invalid product name");
    }
}
