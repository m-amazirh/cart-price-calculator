package com.capco.customermanagement.domain.valueobject;

import com.capco.customermanagement.domain.exception.InvalidVatNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VatNumberTest {

    @Test
    void givenValidVatNumber_whenCreatingVatNumber_thenInstanceIsCreated() {
        VatNumber vatNumber = new VatNumber(new VatCountryCode("FR"), "123456");
        assertEquals("FR", vatNumber.getCountryCode().getCountryCode());
        assertEquals("123456", vatNumber.getNationalIdentifier());
    }

    @Test
    void givenInvalidVatFormat_whenCreatingVatNumber_thenInvalidVatNumberIsThrown() {
        assertThrows(InvalidVatNumber.class, 
            () -> new VatNumber(new VatCountryCode("FR"), "12"));

        assertThrows(InvalidVatNumber.class,
                () -> new VatNumber(new VatCountryCode("XM"), "123456"));

        assertThrows(InvalidVatNumber.class,
                () -> new VatNumber(new VatCountryCode("F"), "123456"));

        assertThrows(InvalidVatNumber.class,
                () -> new VatNumber(new VatCountryCode(" "), "123456"));
    }
}
