package com.capco.modules.cartmanagement.domain.aggregate;

/**
 * Represents a customer's shopping cart containing items for purchase.
 * Maintains a collection of CartItems and provides operations to manage them.
 */
import com.capco.modules.cartmanagement.domain.exception.CartItemNotFound;
import com.capco.modules.cartmanagement.domain.exception.InvalidCartItemQuantity;
import com.capco.modules.cartmanagement.domain.valueobject.CartId;
import com.capco.sharedkernel.CustomerId;
import com.capco.sharedkernel.MoneyAmount;
import com.capco.sharedkernel.Price;
import com.capco.sharedkernel.ProductId;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    @Getter
    private final CartId cartId;
    @Getter
    private final CustomerId customerId;
    private final Map<ProductId, CartItem> cartItems = new HashMap<>();

    /**
     * Creates a new Cart instance.
     *
     * @param cartId The unique identifier for this cart
     * @param customerId The customer identifier this cart belongs to
     * @throws NullPointerException if cartId or customerId is null
     */
    public Cart(@NonNull CartId cartId, @NonNull CustomerId customerId){
        this.cartId = cartId;
        this.customerId = customerId;
    }

    /**
     * Adds an item to the cart or increments quantity if item already exists.
     *
     * @param id The product identifier
     * @param unitPrice The price per unit of the product
     * @param quantity The quantity to add (must be positive)
     * @throws InvalidCartItemQuantity if quantity is not positive
     * @throws NullPointerException if any parameter is null
     */
    public void addItem(@NonNull ProductId id, @NonNull Price unitPrice, @NonNull Integer quantity){
        if(quantity<=0){
            throw new InvalidCartItemQuantity();
        }

        if(!cartItems.containsKey(id)){
            CartItem newItem = new CartItem(id, unitPrice, quantity);
            cartItems.put(id, newItem);
        }else{
            CartItem existingItem = cartItems.get(id);
            existingItem.addQuantity(quantity);
        }
    }

    /**
     * Updates the quantity of an existing cart item.
     * Removes the item if quantity becomes zero.
     *
     * @param id The product identifier of item to update
     * @param quantity The new quantity (must not be negative)
     * @throws CartItemNotFound if product is not in cart
     * @throws InvalidCartItemQuantity if quantity is negative
     * @throws NullPointerException if any parameter is null
     */
    public void updateItemQuantity(@NonNull ProductId id, @NonNull Integer quantity){
        if(!cartItems.containsKey(id)){
            throw new CartItemNotFound();
        }

        CartItem itemToUpdate = cartItems.get(id);
        itemToUpdate.updateQuantity(quantity);

        if(itemToUpdate.getQuantity().equals(0)){
            cartItems.remove(id);
        }
    }

    /**
     * Removes an item from the cart.
     *
     * @param id The product identifier of item to remove
     * @throws CartItemNotFound if product is not in cart
     * @throws NullPointerException if id is null
     */
    public void removeItem(@NonNull ProductId id){
        if(!cartItems.containsKey(id)){
            throw new CartItemNotFound();
        }

        cartItems.remove(id);
    }

    /**
     * Calculates the total price of all items in the cart.
     *
     * @return The total price as a Price object
     *         Returns zero Price if cart is empty
     */
    public Price calculateTotalPrice(){
        return cartItems.values().stream()
                .map(cartItem -> cartItem.calculateTotalPrice())
                .reduce((sum, price) -> sum.add(price))
                .orElse(new Price(BigDecimal.ZERO, MoneyAmount.SYSTEM_CURRENCY));
    }
}
