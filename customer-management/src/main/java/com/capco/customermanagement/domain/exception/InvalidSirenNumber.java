package com.capco.customermanagement.domain.exception;

import com.capco.shared.domain.exception.DomainValidationException;
import lombok.Value;

@Value
public class InvalidSirenNumber extends DomainValidationException {
    public InvalidSirenNumber() {
        super("Invalid Siren Number");
    }
}
