package com.capco.shared.domain.valueobject;

import com.capco.shared.domain.exception.InvalidMoneyAmount;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Currency;

public class Price extends MoneyAmount {

    /**
     * Creates a new com.capco.capco.shared.MoneyAmount
     *
     * @param amount   the monetary amount (must not be null)
     * @param currency the currency (must not be null and must be EUR)
     * @throws InvalidMoneyAmount if currency is not EUR
     */
    public Price(@NonNull BigDecimal amount, @NonNull Currency currency) {
        super(amount, currency);
        if(!isAmountValid(amount)){
            throw new InvalidMoneyAmount();
        }
    }

    public Price multiply(@NonNull Integer quantity){

        return new Price(getAmount().multiply(BigDecimal.valueOf(quantity)), getCurrency());
    }

    public Price add(@NonNull Price thatPrice){
        if(!isCurrencyValid(thatPrice.getCurrency())){
            throw new InvalidMoneyAmount();
        }

        return new Price(thatPrice.getAmount().add(getAmount()), getCurrency());
    }

    private boolean isAmountValid(@NonNull BigDecimal inputAmount){
        BigDecimal zeroValue = new BigDecimal(0);
        return inputAmount.compareTo(zeroValue)>=0;
    }
}
