package com.capco.modules.customermanagement.exception;

import com.capco.shared.DomainValidationException;

public class InvalidCompanyName extends DomainValidationException {
    public InvalidCompanyName() {
        super("Invalid company name");
    }
}
