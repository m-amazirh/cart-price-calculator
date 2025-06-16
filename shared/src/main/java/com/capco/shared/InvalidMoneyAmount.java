package com.capco.shared;

public class InvalidMoneyAmount extends DomainValidationException {
    public InvalidMoneyAmount() {
        super("Invalid money amount");
    }
}
