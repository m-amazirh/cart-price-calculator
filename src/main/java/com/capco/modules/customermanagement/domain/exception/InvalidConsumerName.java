package com.capco.modules.customermanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;

public class InvalidConsumerName extends DomainValidationException {
    public InvalidConsumerName() {
        super("Invalid consumer name");
    }
}
