package com.capco.customermanagement.domain.valueobject;

import com.capco.shared.InvalidMoneyAmount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnnualTurnoverTest {
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
