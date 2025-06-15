package com.capco.cartmanagement.domain.valueobject;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

/**
 * Base class for identifier value objects in the domain.
 * Provides a common implementation using UUID as the underlying value.
 */
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
}
