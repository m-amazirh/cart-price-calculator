package com.capco.customermanagement.domain.exception;

import com.capco.shared.domain.exception.DomainValidationException;

public class InvalidCompanyName extends DomainValidationException {
    public InvalidCompanyName() {
        super("Invalid company name");
    }
}
