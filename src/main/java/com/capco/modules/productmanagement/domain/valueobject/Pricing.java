package com.capco.modules.productmanagement.domain.valueobject;

import com.capco.modules.productmanagement.domain.exception.PriceNotConfiguredError;
import com.capco.sharedkernel.CustomerCategory;
import com.capco.sharedkernel.Price;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Pricing {
    private final Map<CustomerCategory, Price> pricePerCustomerCategory = new HashMap<>();

    public void setBasePrice(@NonNull CustomerCategory category, @NonNull Price basePrice){
        this.pricePerCustomerCategory.put(category, basePrice);
    }

    public Price getBasePrice(@NonNull CustomerCategory category){
        if(!this.pricePerCustomerCategory.containsKey(category)){
            throw new PriceNotConfiguredError();
        }

        return this.pricePerCustomerCategory.get(category);
    }


}
