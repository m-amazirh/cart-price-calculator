package com.capco.shared;

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
    protected final static String SYSTEM_CURRENCY_CODE = "EUR";
    @Getter
    protected final Currency currency;
    @Getter
    protected final BigDecimal amount;

    /**
     * Creates a new MoneyAmount
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
    public boolean isCurrencyValid(Currency inputCurrency){
        return SYSTEM_CURRENCY_CODE.equals(inputCurrency.getCurrencyCode().toUpperCase());
    }
}
