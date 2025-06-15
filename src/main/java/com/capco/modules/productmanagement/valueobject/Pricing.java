package com.capco.modules.productmanagement.valueobject;

import com.capco.modules.productmanagement.exception.PriceNotConfiguredError;
import com.capco.shared.CustomerCategory;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Pricing {
    private final Map<CustomerCategory, BasePrice> pricePerCustomerCategory = new HashMap<>();

    public void setPrice(@NonNull CustomerCategory category, @NonNull BasePrice price){
        this.pricePerCustomerCategory.put(category, price);
    }

    public BasePrice getPrice(@NonNull CustomerCategory category){
        if(!this.pricePerCustomerCategory.containsKey(category)){
            throw new PriceNotConfiguredError();
        }

        return this.pricePerCustomerCategory.get(category);
    }


}
