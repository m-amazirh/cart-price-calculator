package com.capco.customermanagement.domain.exception;

import com.capco.shared.DomainValidationException;

public class InvalidConsumerName extends DomainValidationException {
    public InvalidConsumerName() {
        super("Invalid consumer name");
    }
}
