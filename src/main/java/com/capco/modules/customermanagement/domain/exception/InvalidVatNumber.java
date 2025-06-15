package com.capco.modules.customermanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;

public class InvalidVatNumber extends DomainValidationException {
    public InvalidVatNumber() {
        super("Invalid VAT Number");
    }
}
