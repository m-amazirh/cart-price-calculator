package com.capco.cartmanagement.domain.valueobject;

import com.capco.sharedkernel.InvalidMoneyAmount;
import com.capco.modules.customermanagement.domain.valueobject.AnnualTurnover;
import com.capco.sharedkernel.MoneyAmount;
import com.capco.sharedkernel.Price;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Currency;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void givenValidPositiveAmount_whenCreatingAnnualTurnover_thenInstanceIsCreated() {
        AnnualTurnover turnover = new AnnualTurnover(new BigDecimal("1000000.00"), Currency.getInstance("EUR"));
        assertEquals("EUR", turnover.getCurrency().getCurrencyCode());
        assertEquals(new BigDecimal("1000000.00"), turnover.getAmount());
    }

    @Test
    void givenNegativeAmount_whenCreatingAnnualTurnover_thenThrowsInvalidMoneyAmount() {
        assertThrows(InvalidMoneyAmount.class,
            () -> new AnnualTurnover(new BigDecimal("-1000000.00"), Currency.getInstance("EUR")));
    }

    @Test
    void givenNonEurCurrency_whenCreatingAnnualTurnover_thenThrowsInvalidMoneyAmount() {
        assertThrows(InvalidMoneyAmount.class,
            () -> new AnnualTurnover(new BigDecimal("-1000000.00"), Currency.getInstance("USD")));
    }
}
