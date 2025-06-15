package com.capco.modules.cartmanagement.domain.aggregate;

import com.capco.modules.cartmanagement.domain.exception.CartItemNotFound;
import com.capco.modules.cartmanagement.domain.exception.InvalidCartItemQuantity;
import com.capco.modules.cartmanagement.domain.valueobject.CartId;
import com.capco.modules.cartmanagement.domain.valueobject.CartItem;
import com.capco.sharedkernel.CustomerId;
import com.capco.sharedkernel.MoneyAmount;
import com.capco.sharedkernel.Price;
import com.capco.sharedkernel.ProductId;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final CartId cartId;
    private final CustomerId customerId;
    private final Map<ProductId, CartItem> cartItems = new HashMap<>();

    public Cart(@NonNull CartId cartId, @NonNull CustomerId customerId){
        this.cartId = cartId;
        this.customerId = customerId;
    }

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

    public void removeItem(@NonNull ProductId id){
        if(!cartItems.containsKey(id)){
            throw new CartItemNotFound();
        }

        cartItems.remove(id);
    }

    public Price calculateTotalPrice(){
        return cartItems.values().stream()
                .map(cartItem -> cartItem.calculateTotalPrice())
                .reduce((sum, price) -> sum.add(price))
                .orElse(new Price(BigDecimal.ZERO, MoneyAmount.SYSTEM_CURRENCY));
    }
}
