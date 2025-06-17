package com.capco.customermanagement.domain.aggregate;

import com.capco.customermanagement.domain.valueobject.ConsumerName;
import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.ConsumerCategory;
import com.capco.shared.domain.valueobject.CustomerId;
import lombok.EqualsAndHashCode;
import lombok.Value;


/**
 * Represents an individual consumer customer in the system.
 * <p>
 * A consumer has a name and always belongs to the Consumer category.
 * </p>
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class Consumer extends Customer{
    /**
     * The consumer's name information.
     */
    private final ConsumerName name;
    /**
     * Constructs a new Consumer with the given identifier and name.
     *
     * @param customerId the unique customer identifier (must not be null)
     * @param name the consumer's name information (must not be null)
     * @throws NullPointerException if any parameter is null
     */
    public Consumer(CustomerId customerId, ConsumerName name) {
        super(customerId);
        this.name = name;
    }

    /**
     * Gets the category of this consumer.
     * <p>
     * Consumers always belong to the Consumer category.
     * </p>
     * 
     * @return the ConsumerCategory instance (never null)
     */
    @Override
    public CustomerCategory getCategory() {
        return ConsumerCategory.INSTANCE;
    }
}
