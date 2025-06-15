package com.capco.modules.productmanagement.valueobject;

import com.capco.shared.MoneyAmount;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Represents the base price of a product.
 * Extends MoneyAmount and inherits its currency validation.
 */
@Value
public class BasePrice extends MoneyAmount {
    /**
     * Creates a new BasePrice
     * @param amount the monetary amount (must not be null)
     * @param currency the currency (must not be null and must be EUR)
     * @throws InvalidMoneyAmount if currency is not EUR
     */
    public BasePrice(@NonNull BigDecimal amount, @NonNull Currency currency) {
        super(amount, currency);
    }
}
