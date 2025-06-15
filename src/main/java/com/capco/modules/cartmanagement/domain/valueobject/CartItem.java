package com.capco.modules.cartmanagement.domain.valueobject;

import com.capco.modules.cartmanagement.domain.exception.InvalidCartItemQuantity;
import com.capco.sharedkernel.Price;
import com.capco.sharedkernel.ProductId;
import lombok.Data;
import lombok.NonNull;

@Data
public class CartItem {
    @NonNull
    private final ProductId productId;
    @NonNull
    private final Price unitPrice;
    @NonNull
    private Integer quantity;

    public Price calculateTotalPrice(){
        return unitPrice.multiply(quantity);
    }

    public void addQuantity(@NonNull Integer quantityToAdd){
        this.updateQuantity(this.getQuantity() + quantityToAdd);
        this.quantity += quantityToAdd;
    }

    public void removeQuantity(@NonNull Integer quantityToRemove){
        this.updateQuantity(this.getQuantity() - quantityToRemove);
    }

    public void updateQuantity(@NonNull Integer newQuantity){
        if(newQuantity<0){
            throw new InvalidCartItemQuantity();
        }
    }


}
