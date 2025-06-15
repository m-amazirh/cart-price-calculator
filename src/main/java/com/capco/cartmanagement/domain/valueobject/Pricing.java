package com.capco.cartmanagement.domain.valueobject;

import javax.money.MonetaryAmount;
import java.util.HashMap;
import java.util.Map;

public class Pricing {
    private final Map<CustomerCategory, BasePrice> pricePerCustomerCategory = new HashMap<>();
}
