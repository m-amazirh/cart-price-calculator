package com.capco.customermanagement.domain.valueobject;

import com.capco.customermanagement.domain.exception.InvalidSirenNumber;
import lombok.NonNull;
import lombok.Value;

import java.util.regex.Pattern;

/**
 * Immutable value object representing a validated SIREN number - the official business identification number in France.
 * <p>
 * Enforces strict validation according to French SIREN standards:
 * <ul>
 *   <li>Format: Exactly 9 digits (no letters or special characters)</li>
 *   <li>Luhn Algorithm Validation: The last digit must be a valid control key calculated using:
 *     <ul>
 *       <li>Odd digits (1st, 3rd, 5th, 7th, 9th) summed directly</li>
 *       <li>Even digits doubled (if >4, subtract 9 before summing)</li>
 *       <li>Total sum must be divisible by 10</li>
 *     </ul>
 *   </li>
 * </ul>
 * </p>
 * <p>
 * Throws {@link InvalidSirenNumber} if validation fails, preventing creation of invalid instances.
 * </p>
 * <p>
 * Example valid SIREN: 732829320 (LVMH Moët Hennessy Louis Vuitton)
 * </p>
 *
 * @see <a href="https://www.insee.fr/en/metadonnees/definition/c2047">INSEE SIREN definition</a>
 */
@Value
public class SirenNumber {
    /**
     * Regular expression pattern validating the SIREN number format (exactly 9 digits)
     */
    private final static Pattern pattern = Pattern.compile("[0-9]{9}");

    /**
     * The SIREN number value after validation
     */
    private final String value;

    /**
     * Constructs a validated SIREN number
     *
     * @param value The SIREN number to validate and store
     * @throws InvalidSirenNumber if the value doesn't match SIREN format or validation rules
     */
    public SirenNumber(@NonNull String value) {
        if (!isLengthValid(value) || !isNumberValid(value)) {
            throw new InvalidSirenNumber();
        }
        this.value = value;
    }

    /**
     * Validates that the input string has exactly 9 digits
     *
     * @param input The string to validate
     * @return true if the input matches the expected length and digit pattern
     */
    private boolean isLengthValid(@NonNull String input) {
        return pattern.matcher(input).matches();
    }


    /**
     * Validates the SIREN number using the Luhn algorithm.
     * <p>
     * The Luhn algorithm is applied with specific weighting rules:
     * <ul>
     *   <li>Odd-ranked digits (1st, 3rd, 5th, 7th, 9th) are added to the sum.</li>
     *   <li>Even-ranked digits (2nd, 4th, 6th, 8th) are doubled.
     *       If the doubled value is greater than 9, 9 is subtracted from it.
     *       This result is then added to the sum.</li>
     * </ul>
     * </p>
     * <p>
     * The SIREN number is valid if the total sum modulo 10 equals 0.
     * </p>
     *
     * @param input The SIREN number to validate
     * @return true if the SIREN number is valid according to the Luhn algorithm, false otherwise
     */
    private boolean isNumberValid(@NonNull String input) {
        int[] digits = input.chars().map(asciiCode -> asciiCode - 48).toArray();
        int sum = 0;


        for (int idx = 1; idx <= 9; idx++) {
            boolean oddRank = idx % 2 != 0;
            int digit = digits[digits.length - idx];

            if (oddRank) {
                sum += digit;
            } else if (digit > 4) {
                sum += 2 * digit - 9;
            } else {
                sum += 2 * digit;
            }
        }

        return sum % 10 == 0;
    }
}
