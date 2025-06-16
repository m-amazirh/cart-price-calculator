package com.capco.shared;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainValidationException extends RuntimeException{
    @NonNull
    private final String message;
}
