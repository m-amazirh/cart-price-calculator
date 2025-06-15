package com.capco.cartmanagement.domain.exception;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
public class DomainValidationException extends RuntimeException{
    @NonNull
    private final String message;
}
