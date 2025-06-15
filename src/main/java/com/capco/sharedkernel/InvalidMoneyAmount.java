package com.capco.sharedkernel;

public class InvalidMoneyAmount extends DomainValidationException {
    public InvalidMoneyAmount() {
        super("Invalid money amount");
    }
}
