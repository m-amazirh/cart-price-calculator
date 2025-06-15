package com.capco.modules.customermanagement.domain.valueobject;

import com.capco.modules.customermanagement.domain.exception.InvalidVatNumber;
import lombok.NonNull;
import lombok.Value;

/**
 * Immutable value object representing a validated VAT (Value Added Tax) number.
 * <p>
 * A VAT number consists of:
 * <ul>
 *   <li>A valid {@link VatCountryCode} (2-letter ISO country code)</li>
 *   <li>A national identifier that must:
 *     <ul>
 *       <li>Not be blank</li>
 *       <li>Be at least 3 characters long</li>
 *     </ul>
 *   </li>
 * </ul>
 * </p>
 * <p>
 * Throws {@link InvalidVatNumber} if validation fails,
 * preventing creation of invalid instances.
 * </p>
 * <p>
 * Example valid VAT numbers:
 * <ul>
 *   <li>FR12345678901 (France)</li> 
 *   <li>DE136695976 (Germany)</li>
 * </ul>
 * </p>
 */
@Value
public class VatNumber {
    /**
     * The country code associated with the VAT number.
     */
    @NonNull
    private final VatCountryCode countryCode;
    /**
     * The national identifier part of the VAT number.
     */
    @NonNull
    private final String nationalIdentifier;

    /**
     * Constructs a new VAT number.
     *
     * @param countryCode The country code associated with the VAT number.
     * @param nationalIdentifier The national identifier part of the VAT number.
     * @throws InvalidVatNumber If the national identifier is invalid.
     */
    public VatNumber(VatCountryCode countryCode, String nationalIdentifier){
        if(!isNatonalIdentifierValid(nationalIdentifier)){
            throw new InvalidVatNumber();
        }

        this.countryCode = countryCode;
        this.nationalIdentifier = nationalIdentifier;
    }

    /**
     * Validates the national identifier.
     *
     * @param inputNationalIdentifier The national identifier to validate.
     * @return True if the national identifier is valid, false otherwise.
     */
    private boolean isNatonalIdentifierValid(@NonNull String inputNationalIdentifier){
        return !inputNationalIdentifier.isBlank() && inputNationalIdentifier.length()>2;
    }
    
}
