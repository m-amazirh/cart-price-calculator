package com.capco.customermanagement.domain.aggregate;

import com.capco.customermanagement.domain.exception.InvalidCompanyName;
import com.capco.customermanagement.domain.valueobject.AnnualTurnover;
import com.capco.customermanagement.domain.valueobject.SirenNumber;
import com.capco.customermanagement.domain.valueobject.VatNumber;
import com.capco.shared.CustomerCategory;
import com.capco.shared.domain.valueobject.BigBusinessCategory;
import com.capco.shared.domain.valueobject.CustomerId;
import com.capco.shared.domain.valueobject.SmallBusinessCategory;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
/**
 * Represents a business customer entity in the system.
 * <p>
 * A business customer has specific attributes like company name, SIREN number,
 * VAT number (optional), and annual turnover which determines its category.
 * </p>
 */
public class Business extends Customer{
    /**
     * The currency code used for all monetary values in the system (EUR).
     */
    private static final String SYSTEM_CURRENCY_CODE = "EUR";
    private final String companyName;
    private final SirenNumber sirenNumber;
    private final Optional<VatNumber> vatNumber;
    private final AnnualTurnover annualTurnover;

    /**
     * Constructs a Business customer with all possible attributes.
     *
     * @param customerId the unique customer identifier (must not be null)
     * @param companyName the legal company name (must not be null or blank)
     * @param sirenNumber the SIREN identification number (must not be null)
     * @param annualTurnover the annual revenue information (must not be null)
     * @param vatNumber the optional VAT number (must not be null, but can be empty)
     * @throws InvalidCompanyName if companyName is blank
     * @throws NullPointerException if any required parameter is null
     */
    private Business(@NonNull CustomerId customerId, @NonNull String companyName, @NonNull SirenNumber sirenNumber, @NonNull AnnualTurnover annualTurnover, @NonNull Optional<VatNumber> vatNumber) {
        super(customerId);

        if(!isCompanyNameValid(companyName)){
            throw new InvalidCompanyName();
        }

        this.companyName = companyName;
        this.sirenNumber = sirenNumber;
        this.vatNumber = vatNumber;
        this.annualTurnover = annualTurnover;
    }

    /**
     * Constructs a Business customer with VAT number.
     *
     * @param customerId the unique customer identifier (must not be null)
     * @param companyName the legal company name (must not be null or blank)
     * @param sirenNumber the SIREN identification number (must not be null)
     * @param annualTurnover the annual revenue information (must not be null)
     * @param vatNumber the VAT number (must not be null)
     * @throws InvalidCompanyName if companyName is blank
     * @throws NullPointerException if any required parameter is null
     */
    public Business(@NonNull CustomerId customerId, @NonNull String companyName, @NonNull SirenNumber sirenNumber, @NonNull AnnualTurnover annualTurnover, @NonNull VatNumber vatNumber) {
        this(customerId, companyName, sirenNumber, annualTurnover, Optional.of(vatNumber));
    }

    /**
     * Constructs a Business customer without VAT number.
     *
     * @param customerId the unique customer identifier (must not be null)
     * @param companyName the legal company name (must not be null or blank)
     * @param sirenNumber the SIREN identification number (must not be null)
     * @param annualTurnover the annual revenue information (must not be null)
     * @throws InvalidCompanyName if companyName is blank
     * @throws NullPointerException if any required parameter is null
     */
    public Business(@NonNull CustomerId customerId, @NonNull String companyName, @NonNull SirenNumber sirenNumber, @NonNull AnnualTurnover annualTurnover) {
        this(customerId, companyName, sirenNumber, annualTurnover, Optional.empty());
    }

    /**
     * Determines the customer category based on annual turnover.
     * <p>
     * Businesses with annual turnover of 10 million EUR or more are classified
     * as "Big Business", others as "Small Business".
     * </p>
     * 
     * @return the appropriate customer category (never null)
     */
    @Override
    public CustomerCategory getCategory() {
        return annualTurnover.getAmount().compareTo(BigDecimal.valueOf(10_000_000d))>=0 ?
                BigBusinessCategory.INSTANCE : SmallBusinessCategory.INSTANCE;
    }

    /**
     * Validates that a company name is not blank.
     *
     * @param input the company name to validate (must not be null)
     * @return true if the name is not blank, false otherwise
     * @throws NullPointerException if input is null
     */
    private boolean isCompanyNameValid(@NonNull String input){
        return !input.isBlank();
    }
}
