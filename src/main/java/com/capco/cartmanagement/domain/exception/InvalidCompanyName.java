package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;

public class InvalidCompanyName extends DomainValidationException {
    public InvalidCompanyName() {
        super("Invalid company name");
    }
}
