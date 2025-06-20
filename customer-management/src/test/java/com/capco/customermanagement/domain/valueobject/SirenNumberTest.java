package com.capco.customermanagement.domain.valueobject;

import com.capco.customermanagement.domain.exception.InvalidSirenNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SirenNumberTest {

    @Test
    void givenValidSirenWithLuhnChecksum_whenCreatingSiren_thenInstanceIsCreated() {
        String validCapcoSiren = "381491646";
        SirenNumber sirenNumber = new SirenNumber(validCapcoSiren);
        assertEquals(validCapcoSiren, sirenNumber.getValue());

        String validDellSiren = "351528229";
        sirenNumber = new SirenNumber(validDellSiren);
        assertEquals(validDellSiren, sirenNumber.getValue());
    }

    @Test
    void givenInvalidSirenChecksum_whenCreatingSiren_thenThrowsInvalidSirenNumber() {
        String invalidCapcoSiren = "381451646";
        assertThrows(InvalidSirenNumber.class, () -> new SirenNumber(invalidCapcoSiren));

        String invalidDellSiren = "351521229";
        assertThrows(InvalidSirenNumber.class, () -> new SirenNumber(invalidDellSiren));
    }

    @Test
    void givenIncorrectSirenLength_whenCreatingSiren_thenThrowsIllegalArgumentException() {
        String wrongLengthSiren = "12345"; // Too short
        assertThrows(InvalidSirenNumber.class, () -> new SirenNumber(wrongLengthSiren));
    }
}
