package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;

public class InvalidConsumerName extends DomainValidationException {
    public InvalidConsumerName() {
        super("Invalid consumer name");
    }
}
