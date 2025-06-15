package com.capco.modules.customermanagement.exception;

import com.capco.shared.DomainValidationException;
import lombok.Value;

@Value
public class InvalidSirenNumber extends DomainValidationException {
    public InvalidSirenNumber() {
        super("Invalid Siren Number");
    }
}
