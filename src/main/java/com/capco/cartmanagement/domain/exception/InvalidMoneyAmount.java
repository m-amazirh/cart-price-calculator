package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;

public class InvalidMoneyAmount extends DomainValidationException {
    public InvalidMoneyAmount() {
        super("Invalid money amount");
    }
}
