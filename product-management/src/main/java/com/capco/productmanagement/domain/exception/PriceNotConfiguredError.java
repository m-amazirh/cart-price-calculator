package com.capco.productmanagement.domain.exception;

import com.capco.shared.domain.exception.DomainValidationException;

public class PriceNotConfiguredError extends DomainValidationException {
    public PriceNotConfiguredError() {
        super("Price not configured for queried customer category");
    }
}
