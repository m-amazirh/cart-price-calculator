package com.capco.cartmanagement.domain.valueobject;

import com.capco.cartmanagement.domain.exception.InvalidVatNumber;
import lombok.NonNull;
import lombok.Value;

import java.util.Arrays;
import java.util.Locale;

/**
 * Immutable value object representing a validated VAT country code.
 * <p>
 * Validates that the code:
 * <ul>
 *   <li>Is exactly 2 uppercase letters</li>
 *   <li>Matches a valid ISO 3166-1 alpha-2 country code</li>
 * </ul>
 * </p>
 * <p>
 * Throws {@link com.capco.cartmanagement.domain.exception.InvalidVatNumber} if validation fails,
 * preventing creation of invalid instances.
 * </p>
 * <p>
 * Example valid country codes:
 * <ul>
 *   <li>FR - France</li>
 *   <li>DE - Germany</li>
 *   <li>IT - Italy</li>
 *   <li>ES - Spain</li>
 * </ul>
 * </p>
 * 
 * The current implementations does not handle several edge cases mentioned in the wikipedia article.
 * @see <a href="https://en.wikipedia.org/wiki/VAT_identification_number#Structure">VAT identification number structure</a>
 */
@Value
public class VatCountryCode {
    /**
     * The two-letter ISO country code.
     */
    private final String countryCode;

    /**
     * Constructs a new VAT country code.
     *
     * @param countryCode The two-letter ISO country code.
     * @throws InvalidVatNumber If the provided country code is invalid.
     */
    public VatCountryCode(@NonNull String countryCode){
        if(!isValid(countryCode)){
            throw new InvalidVatNumber();
        }

        this.countryCode = countryCode;
    }

    /**
     * Validates the provided country code.
     *
     * @param input The country code to validate.
     * @return True if the country code is valid, false otherwise.
     */
    private boolean isValid(@NonNull String input){
        if(input.length() != 2 || !input.toUpperCase().equals(input)){
            return false;
        }

        return Arrays.stream(Locale.getISOCountries())
                .filter(isoCode -> input.equals(isoCode.toUpperCase()))
                .findAny()
                .map(val -> true).orElse(false);
    }
}
