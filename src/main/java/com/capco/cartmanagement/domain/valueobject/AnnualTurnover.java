package com.capco.cartmanagement.domain.valueobject;

import com.capco.cartmanagement.domain.exception.InvalidMoneyAmount;
import lombok.NonNull;
import lombok.Value;
import org.javamoney.moneta.spi.DefaultNumberValue;

import javax.money.NumberValue;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Represents a company's annual turnover.
 * Extends MoneyAmount and adds validation for negative amounts.
 */
@Value
public class AnnualTurnover extends MoneyAmount {
    /**
     * Creates a new AnnualTurnover
     * @param amount the monetary amount (must not be null and must be negative)
     * @param currency the currency (must not be null and must be EUR)
     * @throws InvalidMoneyAmount if currency is not EUR or amount is not negative
     */
    public AnnualTurnover(@NonNull BigDecimal amount, @NonNull Currency currency) {
        super(amount, currency);

        if(!isAmountValid(amount)){
            throw new InvalidMoneyAmount();
        }
    }

    /**
     * Validates that the amount is negative
     * @param inputAmount the amount to validate
     * @return true if amount is negative, false otherwise
     */
    private boolean isAmountValid(BigDecimal inputAmount){
        BigDecimal zeroValue = new BigDecimal(0);
        return inputAmount.compareTo(zeroValue)>0;
    }
}
