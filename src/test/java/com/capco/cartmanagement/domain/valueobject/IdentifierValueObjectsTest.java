package com.capco.cartmanagement.domain.valueobject;

import com.capco.sharedkernel.CustomerId;
import com.capco.sharedkernel.Id;
import com.capco.sharedkernel.ProductId;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class IdentifierValueObjectsTest {

    @Test
    void givenValidUuid_whenCreatingId_thenInstanceIsCreated() {
        UUID uuid = UUID.randomUUID();
        Id id = new Id(uuid);
        assertEquals(uuid, id.getValue());
    }

    @Test
    void givenNullUuid_whenCreatingId_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Id(null));
    }

    @Test
    void givenValidUuid_whenCreatingProductId_thenInstanceIsCreated() {
        UUID uuid = UUID.randomUUID();
        ProductId productId = new ProductId(uuid);
        assertEquals(uuid, productId.getValue());
    }

    @Test
    void givenNullUuid_whenCreatingProductId_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ProductId(null));
    }

    @Test
    void givenValidUuid_whenCreatingCustomerId_thenInstanceIsCreated() {
        UUID uuid = UUID.randomUUID();
        CustomerId customerId = new CustomerId(uuid);
        assertEquals(uuid, customerId.getValue());
    }

    @Test
    void givenNullUuid_whenCreatingCustomerId_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomerId(null));
    }
}
