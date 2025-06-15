package com.capco.modules.customermanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;

public class InvalidCompanyName extends DomainValidationException {
    public InvalidCompanyName() {
        super("Invalid company name");
    }
}
