package com.capco.customermanagement.domain.aggregate;

import com.capco.customermanagement.domain.exception.InvalidCompanyName;
import com.capco.shared.CustomerCategory;
import com.capco.shared.CustomerId;
import com.capco.customermanagement.domain.valueobject.SirenNumber;
import com.capco.customermanagement.domain.valueobject.VatNumber;
import com.capco.shared.NotImplementedError;
import lombok.NonNull;

import javax.money.MonetaryAmount;
import java.util.Optional;

public class Business extends Customer{
    private static final String SYSTEM_CURRENCY_CODE = "EUR";
    private final String companyName;
    private final SirenNumber sirenNumber;
    private final Optional<VatNumber> vatNumber;
    private final MonetaryAmount annualTurnover;

    protected Business(@NonNull CustomerId customerId, @NonNull String companyName, @NonNull SirenNumber sirenNumber, @NonNull MonetaryAmount annualTurnover, @NonNull Optional<VatNumber> vatNumber) {
        super(customerId);

        if(!isCompanyNameValid(companyName)){
            throw new InvalidCompanyName();
        }

        this.companyName = companyName;
        this.sirenNumber = sirenNumber;
        this.vatNumber = vatNumber;
        this.annualTurnover = annualTurnover;

    }

    public Business(@NonNull CustomerId customerId, @NonNull String companyName, @NonNull SirenNumber sirenNumber, @NonNull MonetaryAmount annualTurnover, @NonNull VatNumber vatNumber) {
        this(customerId, companyName, sirenNumber, annualTurnover, Optional.of(vatNumber));
    }

    public Business(@NonNull CustomerId customerId, @NonNull String companyName, @NonNull MonetaryAmount annualTurnover, @NonNull SirenNumber sirenNumber) {
        this(customerId, companyName, sirenNumber, annualTurnover, Optional.empty());
    }

    @Override
    public CustomerCategory getCategory() {
        throw new NotImplementedError();
    }

    private boolean isCompanyNameValid(@NonNull String input){
        return !input.isBlank();
    }
}
