package com.capco.cartmanagement.domain.valueobject;

import com.capco.shared.Id;
import lombok.NonNull;

import java.util.UUID;

public class CartId extends Id {
    /**
     * Constructs a new identifier with the specified UUID value.
     *
     * @param value The UUID value for this identifier
     * @throws NullPointerException if value is null
     */
    public CartId(@NonNull UUID value) {
        super(value);
    }
}
