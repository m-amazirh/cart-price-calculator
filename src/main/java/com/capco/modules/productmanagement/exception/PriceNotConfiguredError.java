package com.capco.modules.productmanagement.exception;

import com.capco.shared.DomainValidationException;

public class PriceNotConfiguredError extends DomainValidationException {
    public PriceNotConfiguredError() {
        super("Price not configured for queried customer category");
    }
}
