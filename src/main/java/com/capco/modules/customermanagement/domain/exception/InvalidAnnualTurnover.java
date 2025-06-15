package com.capco.modules.customermanagement.domain.exception;

import com.capco.sharedkernel.DomainValidationException;

public class InvalidAnnualTurnover extends DomainValidationException {
    public InvalidAnnualTurnover() {
        super("Invalid annual turnover");
    }
}
