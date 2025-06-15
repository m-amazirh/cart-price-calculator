package com.capco.cartmanagement.domain.valueobject;

import lombok.Value;

/**
 * Value object representing a customer identifier.
 * <p>
 * This is a specialized {@link Id} for identifying Customer domain entities.
 * Uses UUID as the underlying value type.
 * </p>
 * @see Id
 */
@Value
public class CustomerId extends Id {

}
