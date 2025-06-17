package com.capco.cartmanagement.domain.aggregate;

import com.capco.cartmanagement.domain.exception.InvalidCartItemQuantity;
import com.capco.shared.domain.valueobject.MoneyAmount;
import com.capco.shared.domain.valueobject.Price;
import com.capco.shared.domain.valueobject.ProductId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CartItemTest {

    @Test
    void givenValidParams_whenCreatingCartItem_thenInstanceIsCreated() {
        ProductId productId = new ProductId(UUID.randomUUID());
        Price price = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        CartItem item = new CartItem(productId, price, 1);
        
        assertEquals(productId, item.getProductId());
        assertEquals(price, item.getUnitPrice());
        assertEquals(1, item.getQuantity());
    }

    @Test
    void givenNullProductId_whenCreatingCartItem_thenThrowsNullPointerException() {
        Price price = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        
        assertThrows(NullPointerException.class,
            () -> new CartItem(null, price, 1));
    }

    @Test
    void givenNullPrice_whenCreatingCartItem_thenThrowsNullPointerException() {
        ProductId productId = new ProductId(UUID.randomUUID());
        
        assertThrows(NullPointerException.class,
            () -> new CartItem(productId, null, 1));
    }

    @Test
    void givenNullQuantity_whenCreatingCartItem_thenThrowsNullPointerException() {
        ProductId productId = new ProductId(UUID.randomUUID());
        Price price = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        
        assertThrows(NullPointerException.class,
            () -> new CartItem(productId, price, null));
    }

    @Test
    void givenItem_whenCalculatingTotalPrice_thenReturnsCorrectValue() {
        ProductId productId = new ProductId(UUID.randomUUID());
        Price price = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        CartItem item = new CartItem(productId, price, 3);
        
        Price total = item.calculateTotalPrice();
        
        assertEquals(30, total.getAmount().intValue());
    }

    @Test
    void givenPositiveQuantity_whenAddingQuantity_thenQuantityIsUpdated() {
        CartItem item = createTestItem();
        item.addQuantity(2);
        
        assertEquals(3, item.getQuantity());
    }

    @Test
    void givenNegativeResult_whenAddingQuantity_thenThrowsInvalidCartItemQuantity() {
        CartItem item = createTestItem();
        
        assertThrows(InvalidCartItemQuantity.class,
            () -> item.addQuantity(-2));
    }

    @Test
    void givenNullQuantity_whenAddingQuantity_thenThrowsNullPointerException() {
        CartItem item = createTestItem();
        
        assertThrows(NullPointerException.class,
            () -> item.addQuantity(null));
    }

    @Test
    void givenPositiveQuantity_whenRemovingQuantity_thenQuantityIsUpdated() {
        CartItem item = createTestItem(5); // Start with quantity 5
        item.removeQuantity(2);
        
        assertEquals(3, item.getQuantity());
    }

    @Test
    void givenNegativeResult_whenRemovingQuantity_thenThrowsInvalidCartItemQuantity() {
        CartItem item = createTestItem();
        
        assertThrows(InvalidCartItemQuantity.class,
            () -> item.removeQuantity(2));
    }

    @Test
    void givenNullQuantity_whenRemovingQuantity_thenThrowsNullPointerException() {
        CartItem item = createTestItem();
        
        assertThrows(NullPointerException.class,
            () -> item.removeQuantity(null));
    }

    @Test
    void givenValidQuantity_whenUpdatingQuantity_thenQuantityIsUpdated() {
        CartItem item = createTestItem();
        item.updateQuantity(5);
        
        assertEquals(5, item.getQuantity());
    }

    @Test
    void givenNegativeQuantity_whenUpdatingQuantity_thenThrowsInvalidCartItemQuantity() {
        CartItem item = createTestItem();
        
        assertThrows(InvalidCartItemQuantity.class,
            () -> item.updateQuantity(-1));
    }

    @Test
    void givenNullQuantity_whenUpdatingQuantity_thenThrowsNullPointerException() {
        CartItem item = createTestItem();
        
        assertThrows(NullPointerException.class,
            () -> item.updateQuantity(null));
    }

    private CartItem createTestItem() {
        return createTestItem(1);
    }

    private CartItem createTestItem(int quantity) {
        ProductId productId = new ProductId(UUID.randomUUID());
        Price price = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        return new CartItem(productId, price, quantity);
    }
}
