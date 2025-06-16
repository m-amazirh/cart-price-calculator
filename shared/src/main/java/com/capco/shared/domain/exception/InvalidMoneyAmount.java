package com.capco.shared.domain.exception;

public class InvalidMoneyAmount extends DomainValidationException {
    public InvalidMoneyAmount() {
        super("Invalid money amount");
    }
}
