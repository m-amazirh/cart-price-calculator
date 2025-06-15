package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;

public class InvalidVatNumber extends DomainValidationException{
    public InvalidVatNumber() {
        super("Invalid VAT Number");
    }
}
