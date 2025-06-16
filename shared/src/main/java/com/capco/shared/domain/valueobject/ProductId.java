package com.capco.shared.domain.valueobject;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.UUID;


public class ProductId extends Id {
    /**
     * Constructs a new identifier with the specified UUID value.
     *
     * @param value The UUID value for this identifier
     * @throws NullPointerException if value is null
     */
    public ProductId(@NonNull UUID value) {
        super(value);
    }

    public static ProductId fromString(@NonNull String value){
        return new ProductId(UUID.fromString(value));
    }
}
