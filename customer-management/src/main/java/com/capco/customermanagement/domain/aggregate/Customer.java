package com.capco.customermanagement.domain.aggregate;

import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.CustomerId;
import lombok.Getter;
import lombok.NonNull;

/**
 * Base abstract class representing a customer in the system.
 * <p>
 * Provides common customer functionality and defines the contract
 * for customer category determination that must be implemented by subclasses.
 * </p>
 */
public abstract class Customer {
    @Getter
    private final CustomerId customerId;

    /**
     * Constructs a new Customer with the specified unique identifier.
     *
     * @param customerId the unique identifier for this customer (must not be null)
     * @throws NullPointerException if customerId is null
     */
    public Customer(@NonNull CustomerId customerId){
        this.customerId = customerId;
    }


    /**
     * Gets the category of this customer.
     * <p>
     * Implementations must determine and return the appropriate customer category
     * based on their specific business rules.
     * </p>
     * 
     * @return the customer category (never null)
     */
    public abstract CustomerCategory getCategory();
}
