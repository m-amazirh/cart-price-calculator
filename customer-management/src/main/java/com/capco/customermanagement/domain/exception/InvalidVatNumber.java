package com.capco.customermanagement.domain.exception;

import com.capco.shared.domain.exception.DomainValidationException;

public class InvalidVatNumber extends DomainValidationException {
    public InvalidVatNumber() {
        super("Invalid VAT Number");
    }
}
