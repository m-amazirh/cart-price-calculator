package com.capco.customermanagement.domain.exception;

import com.capco.shared.DomainValidationException;

public class InvalidAnnualTurnover extends DomainValidationException {
    public InvalidAnnualTurnover() {
        super("Invalid annual turnover");
    }
}
