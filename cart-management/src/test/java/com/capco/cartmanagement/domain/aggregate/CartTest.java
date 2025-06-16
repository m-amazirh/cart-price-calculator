package com.capco.cartmanagement.domain.aggregate;

import com.capco.cartmanagement.domain.exception.CartItemNotFound;
import com.capco.cartmanagement.domain.exception.InvalidCartItemQuantity;
import com.capco.cartmanagement.domain.valueobject.CartId;
import com.capco.shared.CustomerId;
import com.capco.shared.MoneyAmount;
import com.capco.shared.Price;
import com.capco.shared.ProductId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    void givenNullCartId_whenCreatingCart_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, 
            () -> new Cart(null, new CustomerId(UUID.randomUUID())));
    }

    @Test
    void givenNullCustomerId_whenCreatingCart_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class,
            () -> new Cart(new CartId(UUID.randomUUID()), null));
    }

    @Test
    void givenCartWithSingleItemQuantity2_whenCalculatingTotal_thenReturnsPriceTimes2() {
        ProductId productId = new ProductId(UUID.randomUUID());
        Price price = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        
        cart.addItem(productId, price, 2);
        Price total = cart.calculateTotalPrice();
        
        assertEquals(20, total.getAmount().intValue());
    }

    @Test
    void givenInvalidQuantity_whenAddingItem_thenThrowsInvalidCartItemQuantity() {
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        assertThrows(InvalidCartItemQuantity.class,
            () -> cart.addItem(new ProductId(UUID.randomUUID()), 
                             new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY), 
                             0));
    }

    @Test
    void givenExistingItem_whenAddingSameItem_thenIncrementsQuantity() {
        ProductId productId = new ProductId(UUID.randomUUID());
        Price price = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        
        cart.addItem(productId, price, 1);
        cart.addItem(productId, price, 2);
        
        assertEquals(price.multiply(3).getAmount().intValue(), cart.calculateTotalPrice().getAmount().intValue());
    }

    @Test
    void givenCartWithMultipleItems_whenCalculatingTotal_thenReturnsSumOfPriceTimesQuantity() {
        ProductId product1 = new ProductId(UUID.randomUUID());
        ProductId product2 = new ProductId(UUID.randomUUID());
        Price price1 = new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY);
        Price price2 = new Price(new BigDecimal("15.50"), MoneyAmount.SYSTEM_CURRENCY);
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        
        cart.addItem(product1, price1, 2);
        cart.addItem(product2, price2, 3);
        Price total = cart.calculateTotalPrice();
        
        assertEquals(new BigDecimal("66.50"), total.getAmount());
    }

    @Test
    void givenNonExistentItem_whenUpdatingQuantity_thenThrowsCartItemNotFound() {
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        assertThrows(CartItemNotFound.class,
            () -> cart.updateItemQuantity(new ProductId(UUID.randomUUID()), 2));
    }

    @Test
    void givenQuantityZero_whenUpdatingQuantity_thenRemovesItem() {
        ProductId productId = new ProductId(UUID.randomUUID());
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        cart.addItem(productId, new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY), 1);
        
        cart.updateItemQuantity(productId, 0);
        
        assertTrue(cart.calculateTotalPrice().getAmount().compareTo(BigDecimal.ZERO) == 0);
    }

    @Test
    void givenEmptyCart_whenCalculatingTotal_thenReturnsZero() {
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        Price total = cart.calculateTotalPrice();
        assertEquals(0, total.getAmount().intValue());
    }

    @Test
    void givenNonExistentItem_whenRemovingItem_thenThrowsCartItemNotFound() {
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        assertThrows(CartItemNotFound.class,
            () -> cart.removeItem(new ProductId(UUID.randomUUID())));
    }

    @Test
    void givenExistingItem_whenRemovingItem_thenItemIsRemoved() {
        ProductId productId = new ProductId(UUID.randomUUID());
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        cart.addItem(productId, new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY), 1);
        
        cart.removeItem(productId);
        
        assertTrue(cart.calculateTotalPrice().getAmount().compareTo(BigDecimal.ZERO) == 0);
    }

    @Test
    void givenNullItem_whenRemovingItem_thenThrowsNullPointerException() {
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        assertThrows(NullPointerException.class,
            () -> cart.removeItem(null));
    }

    @Test 
    void givenMultipleItems_whenRemovingOneItem_thenOtherItemsRemain() {
        ProductId product1 = new ProductId(UUID.randomUUID());
        ProductId product2 = new ProductId(UUID.randomUUID());
        Cart cart = new Cart(new CartId(UUID.randomUUID()), new CustomerId(UUID.randomUUID()));
        cart.addItem(product1, new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY), 2);
        cart.addItem(product2, new Price(BigDecimal.TEN, MoneyAmount.SYSTEM_CURRENCY), 3);
        
        cart.removeItem(product1);
        
        assertEquals(30, cart.calculateTotalPrice().getAmount().intValue());
    }
}
