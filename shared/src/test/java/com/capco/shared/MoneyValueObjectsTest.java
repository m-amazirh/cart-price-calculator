package com.capco.shared;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyValueObjectsTest {

    @Test
    void givenValidEurAmount_whenCreatingMoneyAmount_thenInstanceIsCreated() {
        MoneyAmount money = new MoneyAmount(new BigDecimal("100.50"), Currency.getInstance("EUR"));
        assertEquals("EUR", money.getCurrency().getCurrencyCode());
        assertEquals(new BigDecimal("100.50"), money.getAmount());
    }

    @Test
    void givenNonEurCurrency_whenCreatingMoneyAmount_thenThrowsInvalidMoneyAmount() {
        assertThrows(InvalidMoneyAmount.class, 
            () -> new MoneyAmount(new BigDecimal("100.50"), Currency.getInstance("USD")));
    }

    @Test
    void givenValidEurAmount_whenCreatingPrice_thenInstanceIsCreated() {
        Price price = new Price(new BigDecimal("50.75"), Currency.getInstance("EUR"));
        assertEquals("EUR", price.getCurrency().getCurrencyCode());
        assertEquals(new BigDecimal("50.75"), price.getAmount());
    }

    @Test
    void givenNonEurCurrency_whenCreatingPrice_thenThrowsInvalidMoneyAmount() {
        assertThrows(InvalidMoneyAmount.class,
            () -> new Price(new BigDecimal("50.75"), Currency.getInstance("GBP")));
    }

}
