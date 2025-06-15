package com.capco.cartmanagement.domain.aggregate;

import com.capco.cartmanagement.domain.exception.InvalidProductName;
import com.capco.cartmanagement.domain.valueobject.ProductId;
import lombok.NonNull;

public class Product {
    private final ProductId productId;
    private final String name;

    public Product(@NonNull ProductId productId, @NonNull String name){
        if(!isNameValid(name)){
            throw new InvalidProductName();
        }
        this.productId = productId;
        this.name = name;
    }

    private boolean isNameValid(String inputName){
        return !inputName.isBlank();
    }
}
