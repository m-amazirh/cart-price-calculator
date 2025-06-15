package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;

public class InvalidAnnualTurnover extends DomainValidationException {
    public InvalidAnnualTurnover() {
        super("Invalid annual turnover");
    }
}
