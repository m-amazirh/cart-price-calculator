package com.capco.modules.customermanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;
import lombok.Value;

@Value
public class InvalidSirenNumber extends DomainValidationException {
    public InvalidSirenNumber() {
        super("Invalid Siren Number");
    }
}
