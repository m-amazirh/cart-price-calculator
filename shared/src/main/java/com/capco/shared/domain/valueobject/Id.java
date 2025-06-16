package com.capco.shared.domain.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

/**
 * Base class for identifier value objects in the domain.
 * Provides a common implementation using UUID as the underlying value.
 */
@EqualsAndHashCode
public class Id {
    /**
     * The underlying UUID value of this identifier.
     * @see UUID
     */
    @Getter
    protected final UUID value;

    /**
     * Constructs a new identifier with the specified UUID value.
     * @param value The UUID value for this identifier
     * @throws NullPointerException if value is null
     */
    public Id(@NonNull UUID value){
        this.value = value;
    }

    public static Id fromString(@NonNull String value){
        return new Id(UUID.fromString(value));
    }
}
