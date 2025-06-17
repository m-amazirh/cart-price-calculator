package com.capco.shared.domain.valueobject;

import com.capco.shared.domain.exception.InvalidMoneyAmount;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Represents a monetary amount with currency.
 * Validates that the currency matches the system currency (EUR).
 */
public class MoneyAmount {
    /**
     * The system's base currency code (EUR)
     */
    public final static String SYSTEM_CURRENCY_CODE = "EUR";
    public final static Currency SYSTEM_CURRENCY = Currency.getInstance(SYSTEM_CURRENCY_CODE);
    @Getter
    protected final Currency currency;
    @Getter
    protected final BigDecimal amount;

    /**
     * Creates a new com.capco.capco.shared.MoneyAmount
     * @param amount the monetary amount (must not be null)
     * @param currency the currency (must not be null and must be EUR)
     * @throws InvalidMoneyAmount if currency is not EUR
     */
    public MoneyAmount(@NonNull BigDecimal amount, @NonNull Currency currency){
        if(!isCurrencyValid(currency)){
            throw new InvalidMoneyAmount();
        }
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Validates if the input currency matches system currency
     * @param inputCurrency the currency to validate
     * @return true if currency is EUR, false otherwise
     */
    protected boolean isCurrencyValid(Currency inputCurrency){
        return SYSTEM_CURRENCY_CODE.equalsIgnoreCase(inputCurrency.getCurrencyCode());
    }
}
