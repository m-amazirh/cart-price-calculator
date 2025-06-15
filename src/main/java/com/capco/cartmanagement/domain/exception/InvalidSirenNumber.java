package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;
import lombok.Value;

@Value
public class InvalidSirenNumber extends DomainValidationException{
    public InvalidSirenNumber() {
        super("Invalid Siren Number");
    }
}
