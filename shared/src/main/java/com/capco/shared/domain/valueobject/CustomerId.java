package com.capco.shared.domain.valueobject;

import lombok.NonNull;

import java.util.UUID;

/**
 * Value object representing a customer identifier.
 * <p>
 * This is a specialized {@link Id} for identifying Customer domain entities.
 * Uses UUID as the underlying value type.
 * </p>
 * @see Id
 */

public class CustomerId extends Id {

    /**
     * Constructs a new identifier with the specified UUID value.
     *
     * @param value The UUID value for this identifier
     * @throws NullPointerException if value is null
     */
    public CustomerId(@NonNull UUID value) {
        super(value);
    }

    public static CustomerId fromString(@NonNull String value){
        return new CustomerId(UUID.fromString(value));
    }
}
