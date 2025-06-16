package com.capco.modules.cartmanagement.domain.aggregate;

/**
 * Represents an item in a shopping cart with product details and quantity.
 */
import com.capco.modules.cartmanagement.domain.exception.InvalidCartItemQuantity;
import com.capco.sharedkernel.Price;
import com.capco.sharedkernel.ProductId;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CartItem {
    @NonNull
    private final ProductId productId;
    @NonNull
    private final Price unitPrice;
    @NonNull
    private Integer quantity;

    /**
     * Calculates the total price for this cart item (unit price * quantity).
     *
     * @return The calculated total price
     */
    public Price calculateTotalPrice() {
        return unitPrice.multiply(quantity);
    }

    /**
     * Adds to the current quantity of this item.
     *
     * @param quantityToAdd The amount to add (must be positive)
     * @throws InvalidCartItemQuantity if resulting quantity is invalid
     * @throws NullPointerException if quantityToAdd is null
     */
    public void addQuantity(@NonNull Integer quantityToAdd) {
        this.updateQuantity(this.getQuantity() + quantityToAdd);
    }

    /**
     * Removes from the current quantity of this item.
     *
     * @param quantityToRemove The amount to remove (must be positive)
     * @throws InvalidCartItemQuantity if resulting quantity is invalid
     * @throws NullPointerException if quantityToRemove is null
     */
    public void removeQuantity(@NonNull Integer quantityToRemove) {
        this.updateQuantity(this.getQuantity() - quantityToRemove);
    }

    /**
     * Updates the quantity of this item to a new value.
     *
     * @param newQuantity The new quantity (must not be negative)
     * @throws InvalidCartItemQuantity if newQuantity is negative
     * @throws NullPointerException if newQuantity is null
     */
    public void updateQuantity(@NonNull Integer newQuantity) {
        if (newQuantity < 0) {
            throw new InvalidCartItemQuantity();
        }
        this.quantity = newQuantity;
    }


}
