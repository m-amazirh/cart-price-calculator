package com.capco.cartmanagement.application.service;

import com.capco.cartmanagement.application.dto.CartSummaryDto;
import com.capco.cartmanagement.application.mapper.AppMapper;
import com.capco.cartmanagement.domain.aggregate.Cart;
import com.capco.cartmanagement.domain.aggregate.CartItem;
import com.capco.cartmanagement.domain.repository.CartRepository;
import com.capco.cartmanagement.domain.valueobject.CartId;
import com.capco.customermanagement.application.service.CustomerService;
import com.capco.productmanagement.application.dto.ProductDto;
import com.capco.productmanagement.application.service.ProductService;
import com.capco.shared.domain.valueobject.CustomerId;
import com.capco.shared.domain.valueobject.MoneyAmount;
import com.capco.shared.domain.valueobject.Price;
import com.capco.shared.domain.valueobject.ProductId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CartService {
    @NonNull
    private final ProductService productService;
    @NonNull
    private final CustomerService customerService;
    @NonNull
    private final CartRepository cartRepository;
    @NonNull
    private final AppMapper appMapper;

    public String createCart(String customerId){
        CustomerId custId = CustomerId.fromString(customerId);
        CartId cartId = new CartId(UUID.randomUUID());
        Cart cart = new Cart(cartId, custId);

        cartRepository.save(cart);

        return cart.getCartId().getValue().toString();
    }

    public CartSummaryDto getCart(String cartId){
        Cart cart = cartRepository.getCartById(CartId.fromString(cartId));

        Map<String, String> productNames = new HashMap<>();
        Map<String, Double> totalPricePerItem = new HashMap<>();

        cart.getCartItems().entrySet().forEach(entry -> {
            String productId = entry.getKey().getValue().toString();
            CartItem item = entry.getValue();

            ProductDto productDto = productService.getProduct(productId);
            productNames.put(productId, productDto.getName());

            totalPricePerItem.put(productId, item.calculateTotalPrice().getAmount().doubleValue());

        });

        return appMapper.toCartSummaryDto(cart, productNames, totalPricePerItem);
    }

    public void addItem(String cartId, String productId, Integer quantity){
        Cart cart = cartRepository.getCartById(CartId.fromString(cartId));
        ProductDto productDto = productService.getProduct(productId);
        String customerCategory = customerService.getCustomerCategory(cart.getCustomerId().getValue().toString());

        BigDecimal priceAmount = BigDecimal.valueOf(productDto.getPricing().get(customerCategory));
        Price price = new Price(priceAmount, MoneyAmount.SYSTEM_CURRENCY);

        cart.addItem(ProductId.fromString(productId), price, quantity);

        cartRepository.save(cart);
    }

    public void removeItem(String cartId, String productId){
        Cart cart = cartRepository.getCartById(CartId.fromString(cartId));
        cart.removeItem(ProductId.fromString(productId));

        cartRepository.save(cart);
    }

    public void updateItemQuantity(String cartId, String productId, Integer quantity){
        Cart cart = cartRepository.getCartById(CartId.fromString(cartId));
        cart.updateItemQuantity(ProductId.fromString(productId), quantity);
        cartRepository.save(cart);
    }
}
