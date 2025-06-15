package com.capco.modules.customermanagement.exception;

import com.capco.shared.DomainValidationException;

public class InvalidVatNumber extends DomainValidationException {
    public InvalidVatNumber() {
        super("Invalid VAT Number");
    }
}
