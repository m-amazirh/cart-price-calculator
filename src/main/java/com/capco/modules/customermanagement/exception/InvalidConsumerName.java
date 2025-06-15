package com.capco.modules.customermanagement.exception;

import com.capco.shared.DomainValidationException;

public class InvalidConsumerName extends DomainValidationException {
    public InvalidConsumerName() {
        super("Invalid consumer name");
    }
}
