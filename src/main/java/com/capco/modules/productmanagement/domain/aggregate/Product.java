package com.capco.modules.productmanagement.domain.aggregate;

import com.capco.modules.productmanagement.domain.exception.InvalidProductName;
import com.capco.modules.productmanagement.domain.valueobject.Pricing;
import com.capco.sharedkernel.ProductId;
import lombok.NonNull;

public class Product {
    private final ProductId productId;
    private final String name;
    private final Pricing pricing;

    public Product(@NonNull ProductId productId, @NonNull String name, @NonNull Pricing pricing){
        if(!isNameValid(name)){
            throw new InvalidProductName();
        }
        this.productId = productId;
        this.name = name;
        this.pricing = pricing;
    }

    private boolean isNameValid(String inputName){
        return !inputName.isBlank();
    }
}
