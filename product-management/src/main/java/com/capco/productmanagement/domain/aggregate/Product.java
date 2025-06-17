package com.capco.productmanagement.domain.aggregate;

import com.capco.productmanagement.domain.exception.InvalidProductName;
import com.capco.productmanagement.domain.valueobject.Pricing;
import com.capco.shared.domain.valueobject.ProductId;
import lombok.NonNull;
import lombok.Value;

@Value
/**
 * Represents a product in the system.
 * <p>
 * A product has an identifier, name, and pricing information.
 * Validates that product names are not blank.
 * </p>
 */
public class Product {
    /** The unique identifier for this product */
    private final ProductId productId;
    
    /** The name of the product (must not be blank) */
    private final String name;
    
    /** The pricing information for this product */
    private final Pricing pricing;

    /**
     * Constructs a new Product with the given parameters.
     *
     * @param productId the unique product identifier (must not be null)
     * @param name the product name (must not be null or blank)
     * @param pricing the pricing information (must not be null)
     * @throws InvalidProductName if name is blank
     * @throws NullPointerException if any parameter is null
     */
    public Product(@NonNull ProductId productId, @NonNull String name, @NonNull Pricing pricing){
        if(!isNameValid(name)){
            throw new InvalidProductName();
        }
        this.productId = productId;
        this.name = name;
        this.pricing = pricing;
    }

    /**
     * Validates that a product name is not blank.
     *
     * @param inputName the name to validate
     * @return true if the name is not blank, false otherwise
     */
    private boolean isNameValid(String inputName){
        return !inputName.isBlank();
    }
}
