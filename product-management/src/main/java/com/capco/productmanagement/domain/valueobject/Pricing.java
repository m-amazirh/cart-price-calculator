package com.capco.productmanagement.domain.valueobject;

import com.capco.productmanagement.domain.exception.PriceNotConfiguredError;
import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.Price;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the pricing configuration for a product.
 * <p>
 * Maintains a mapping of customer categories to their respective base prices.
 * Allows setting and retrieving base prices for different customer categories.
 * </p>
 */
public class Pricing {
    private final Map<CustomerCategory, Price> pricePerCustomerCategory = new HashMap<>();

    /**
     * Sets the base price for a specific customer category.
     *
     * @param category the customer category (must not be null)
     * @param basePrice the base price for this category (must not be null)
     * @throws NullPointerException if either parameter is null
     */
    public void setBasePrice(@NonNull CustomerCategory category, @NonNull Price basePrice){
        this.pricePerCustomerCategory.put(category, basePrice);
    }

    /**
     * Gets the base price for a specific customer category.
     *
     * @param category the customer category to get price for (must not be null)
     * @return the base price for the specified category
     * @throws PriceNotConfiguredError if no price is configured for the category
     * @throws NullPointerException if category is null
     */
    public Price getBasePrice(@NonNull CustomerCategory category){
        if(!this.pricePerCustomerCategory.containsKey(category)){
            throw new PriceNotConfiguredError();
        }

        return this.pricePerCustomerCategory.get(category);
    }


}
