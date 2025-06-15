package com.capco.modules.productmanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;

public class PriceNotConfiguredError extends DomainValidationException {
    public PriceNotConfiguredError() {
        super("Price not configured for queried customer category");
    }
}
