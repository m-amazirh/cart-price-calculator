package com.capco.customermanagement.domain.exception;

import com.capco.shared.domain.exception.DomainValidationException;

public class InvalidConsumerName extends DomainValidationException {
    public InvalidConsumerName() {
        super("Invalid consumer name");
    }
}
